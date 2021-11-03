package com.cmps312.todoapp.data.repository

import android.util.Log
import com.cmps312.todoapp.data.entity.Project
import com.cmps312.todoapp.data.entity.Todo
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestoreSettings
import kotlinx.coroutines.tasks.await

object TodoListRepo {
    val TAG = "TodoListRepo"
    val db by lazy { FirebaseFirestore.getInstance() }
    val todoDocumentsRef by lazy { db.collection("todos") }
    val projectDocumentsRef by lazy { db.collection("projects") }


    init {
        db.firestoreSettings = firestoreSettings { isPersistenceEnabled = true }
    }

    suspend fun getProjects(): List<Project> =
        projectDocumentsRef.get().await().toObjects(Project::class.java)

    fun addProject(project: Project) = projectDocumentsRef.add(project)
        .addOnSuccessListener { Log.d(TAG, "Project added successfully") }
        .addOnFailureListener { Log.d(TAG, "Failed to add the Project") }

    suspend fun updateProject(updatedProject: Project) =
        projectDocumentsRef.document(updatedProject.id).set(updatedProject)

    suspend fun deleteProject(project: Project) {
        val todosQuerySnapshot =
            todoDocumentsRef.whereEqualTo("projectId", project.id).get().await()
        todosQuerySnapshot.forEach {
            val todo = it.toObject(Todo::class.java)
            todoDocumentsRef.document(todo.id).delete()
        }
        projectDocumentsRef.document(project.id).delete()
    }

    suspend fun getTodoListByProject(pid: String): List<Todo> =
        todoDocumentsRef.whereEqualTo("projectId", pid).get().await().toObjects(Todo::class.java)

    fun addTodo(todo: Todo) = todoDocumentsRef.add(todo)
        .addOnSuccessListener { Log.d(TAG, "Todo added successfully") }
        .addOnFailureListener { Log.d(TAG, "Failed to add the todo") }

    suspend fun getTodo(id: String) =
        todoDocumentsRef.document(id).get().await().toObject(Todo::class.java)
}