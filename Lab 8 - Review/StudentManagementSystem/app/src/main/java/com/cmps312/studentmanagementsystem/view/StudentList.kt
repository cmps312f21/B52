package com.cmps312.studentmanagementsystem.view

import androidx.activity.ComponentActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.cmps312.studentmanagementsystem.model.Student
import com.cmps312.studentmanagementsystem.viewmodel.StudentViewModel

@Composable
fun StudentList(onStudentSelected: () -> Unit) {
    val studentViewModel =
        viewModel<StudentViewModel>(viewModelStoreOwner = LocalContext.current as ComponentActivity)

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxSize(),
        elevation = 16.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            LazyColumn {
                items(studentViewModel.students) { student ->
                    StudentCard(student, onStudentSelected = {
                        //Todo Transfer
                        studentViewModel.selectedStudent = student
                        onStudentSelected()
                    })
                }
            }
        }
    }

}

@Composable
fun StudentCard(student: Student, onStudentSelected: () -> Unit) {
    Card(elevation = 10.dp,
        backgroundColor = Color.LightGray,
        modifier = Modifier
            .padding(10.dp)) {
        Row(modifier = Modifier
            .padding(15.dp)
            .clickable { onStudentSelected() },
            verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Person Image")
            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Id : ${student.studentId}")
                Text(text = "Name : ${student.name}")
                Text(text = "Letter Grade : ${student.grade}")
            }
            Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit Image")
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Image")

        }
    }
}
