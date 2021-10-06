package com.cmps312.studentmanagementsystem

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.cmps312.studentmanagementsystem.ui.theme.StudentManagementSystemTheme
import com.cmps312.studentmanagementsystem.view.StudentList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StudentManagementSystemTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    StudentList() {
                        Toast.makeText(this, "Student is selected", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    StudentManagementSystemTheme {
        Greeting("Android")
    }
}