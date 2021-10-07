package com.cmps312.studentmanagementsystem.view

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()

    Scaffold(
        topBar = { TopBar(navHostController) },
        floatingActionButton = {
            FloatingActionButton(onClick = { navHostController.navigate(Screen.StudentScreen.route)}) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add",
                    tint = Color.Blue)
            }
        }
    ) {
        AppNavHost(navHostController)
    }
}


@Composable
fun TopBar(navHostController: NavHostController) {
    val currentRoute = navHostController
        .currentBackStackEntryAsState()?.value?.destination?.route

    TopAppBar(
        title = {
            Text(text = "Student Management App")
        },
        //Provide the navigation Icon ( Icon on the left to toggle drawer)
            navigationIcon = {
                if (currentRoute != Screen.StudentList.route)
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Menu",
                        modifier = Modifier.clickable(onClick = { navHostController.navigateUp() })
                    )
            }
    )
}

