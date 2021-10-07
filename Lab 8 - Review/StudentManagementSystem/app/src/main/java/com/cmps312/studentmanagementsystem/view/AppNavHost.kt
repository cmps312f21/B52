package com.cmps312.studentmanagementsystem.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavHost(navHostController: NavHostController) {
    NavHost(navController = navHostController,
        startDestination = Screen.StudentList.route) {
        composable(Screen.StudentList.route){ StudentList {}}
        composable(Screen.StudentScreen.route){ StudentScreen{

        }}
    }
}