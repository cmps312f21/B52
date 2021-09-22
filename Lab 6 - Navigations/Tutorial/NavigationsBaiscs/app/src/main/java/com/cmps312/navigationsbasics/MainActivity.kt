package com.cmps312.navigationsbasics

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cmps312.navigationsbasics.ui.theme.NavigationsBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationsBasicsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}

@Composable
fun MyApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "homeScreen") {
        //Mapping /HomeScreen --- take them to this screen
        composable("homescreen") { HomeScreen(navController) }
        composable("detailsScreen") { DetailsScreen(navController) }
    }
}

@Composable
fun HomeScreen(navController: NavController) {
    Column() {
        Text(text = "Home Screen")
        Button(onClick = { navController.navigate("detailsScreen") }) {
            Text("Go to Detail Screen")
        }
    }
}

@Composable
fun DetailsScreen(navController: NavController) {
    Column() {
        Text(text = "Detail Screen")
        Button(onClick = { /*TODO*/ }) {
            Text("Go to Home Screen")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NavigationsBasicsTheme {
        MyApp()
    }
}