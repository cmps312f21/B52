package com.cmps312.studentmanagementsystem.repository

import android.content.Context
import com.cmps312.studentmanagementsystem.model.Student
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

class StudentRepository(private val context: Context) {

    private fun readData(filename: String) =
        context.assets.open(filename).bufferedReader().use { it.readText() }

    public fun getStudents() =
        Json { ignoreUnknownKeys = true }.decodeFromString<List<Student>>(readData("students.json"))
}