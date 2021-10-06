package com.cmps312.studentmanagementsystem.model

import kotlinx.serialization.Serializable

@Serializable
data class Student(val name: String, val grade: String, val studentId: String)
