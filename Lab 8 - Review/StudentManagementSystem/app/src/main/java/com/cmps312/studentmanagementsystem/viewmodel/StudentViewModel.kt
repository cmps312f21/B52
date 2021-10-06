package com.cmps312.studentmanagementsystem.viewmodel

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.AndroidViewModel
import com.cmps312.studentmanagementsystem.model.Student
import com.cmps312.studentmanagementsystem.repository.StudentRepository

class StudentViewModel(appContext: Application) : AndroidViewModel(appContext) {
    val studentRepository = StudentRepository(appContext)

    val students = mutableStateListOf<Student>(*studentRepository.getStudents().toTypedArray())
    lateinit var selectedStudent: Student

    fun addStudent(student: Student) = students.add(student)

    @RequiresApi(Build.VERSION_CODES.N)
    fun deleteStudent(student: Student) = students.removeIf { it.studentId == student.studentId }
    fun updateStudent(updatedStudent: Student) {
        val index = students.indexOfFirst { it.studentId == updatedStudent.studentId }
        students[index] = updatedStudent
    }
}

//data class Employee(val id: Int, var name: String)
//fun main() {
//    val students = mutableListOf<Employee>(Employee(1, "Abdulahi"), Employee(2, "Sara"));
//    println(students)
//
//    val updatedStudent = Employee(1, "Abdulahi Hassen")
//    val index = students.indexOfFirst { it.id == 2 }
//    students[index] = updatedStudent
//
//    println(students)
//
//}