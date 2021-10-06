package com.cmps312.studentmanagementsystem.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddAPhoto
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(val route: String, val title: String, val icon: ImageVector) {
    object StudentList : Screen(route = "studentList", title = "Students List", icon = Icons.Default.List)
    object StudentScreen : Screen(route = "studentScreen", title = "Add Student", icon = Icons.Default.AddAPhoto)
}
