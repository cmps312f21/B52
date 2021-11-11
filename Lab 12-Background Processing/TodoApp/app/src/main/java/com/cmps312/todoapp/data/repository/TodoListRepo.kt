package com.cmps312.todoapp.data.repository

import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.cmps312.todoapp.data.entity.Project
import com.cmps312.todoapp.data.entity.Todo
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestoreSettings
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import java.security.SecureRandom
import java.time.LocalDate

object TodoListRepo {

    val TAG = "TodoListRepo"
    val db by lazy { FirebaseFirestore.getInstance() }
    val projectDocumentsRef by lazy { db.collection("projects") }
    val todosDocumentsRef by lazy { db.collection("todos") }

    init {
        db.firestoreSettings = firestoreSettings { isPersistenceEnabled = true }
    }
    suspend fun getProjects(): List<Project> =
        projectDocumentsRef.get().await().toObjects(Project::class.java)

    fun addProject(project: Project) = projectDocumentsRef.add(project)
        .addOnSuccessListener { Log.d(TAG, "Successfully added: ") }
        .addOnFailureListener { Log.d(TAG, "Failed: ") }

    suspend fun updateProject(updatedProject: Project) =
        projectDocumentsRef.document(updatedProject.id).set(updatedProject)

    suspend fun deleteProject(project: Project) {
        val todos = getTodoListByProject(project.id)
        todos.forEach { todo -> todosDocumentsRef.document(todo.id).delete() }
        projectDocumentsRef.document(project.id).delete()
    }

    suspend fun getTodoListByProject(pid: String): List<Todo> =
        todosDocumentsRef.whereEqualTo("projectId", pid).get().await().toObjects(Todo::class.java)

    fun addTodo(todo: Todo) =
        todosDocumentsRef.add(todo)
            .addOnSuccessListener { Log.d(TAG, "Successfully added: ") }
            .addOnFailureListener { Log.d(TAG, "Failed: ") }


    suspend fun getTodo(id: String) =
        todosDocumentsRef.document(id).get().await().toObject(Todo::class.java)

    //todo add uploadPhoto
    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun uploadPhoto(photoUri: Uri) : String{
        var fileName = "IMAGE_" + SecureRandom().nextInt(10000) + "_.png"
        //a link to our storage
        val storageRef = FirebaseStorage.getInstance().reference
            .child("images")
            .child(fileName)

        var task = storageRef.putFile(photoUri).await()
        //code below will not be executed until the above code finishes

        return storageRef.downloadUrl.await().toString()
    }

}