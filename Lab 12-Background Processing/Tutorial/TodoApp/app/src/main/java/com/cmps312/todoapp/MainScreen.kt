package com.cmps312.todoapp

import androidx.activity.ComponentActivity
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    Scaffold(
        topBar = { TopBar(navHostController) },
        // floatingActionButton = { FAB(navHostController)}

    ) {
        AppNavHost(navHostController)
    }
}

@Composable
fun TopBar(navHostController: NavHostController) {
     //todo add sign in view model
    val currentRoute = navHostController
        .currentBackStackEntryAsState()?.value?.destination?.route
    TopAppBar(
        title = {
            //Todo display the logged in user
            Text(text = "${currentRoute.toString()}")
        },
        //Provide the navigation Icon ( Icon on the left to toggle drawer)

    )
}