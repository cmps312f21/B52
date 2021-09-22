package com.cmps312.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.cmps312.myapplication.component.SearchBar
import com.cmps312.myapplication.component.StadiumList
import com.cmps312.myapplication.repository.StadiumRepo
import com.cmps312.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
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
    var searchText by remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            SearchBar(searchText, onSearch = {
                searchText = it
            })
        },
        content = { Content(searchText) }
    )
}

@Composable
fun Content(searchText : String) {
    val stadiums = when(searchText.isNotEmpty()){
        true -> StadiumRepo.filterStadiumByName(searchText)
        else -> StadiumRepo.getStadiums(LocalContext.current)
    }
    StadiumList(stadiums = stadiums)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MyApp()
    }
}