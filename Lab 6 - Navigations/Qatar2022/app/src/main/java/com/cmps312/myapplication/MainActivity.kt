package com.cmps312.myapplication

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.cmps312.myapplication.component.SearchBar
import com.cmps312.myapplication.component.SortByDD
import com.cmps312.myapplication.component.StadiumList
import com.cmps312.myapplication.repository.SortBy
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
    var selectedOption by remember { mutableStateOf("Sort By") }

    Scaffold(
        topBar = {
            Column() {
                SearchBar(searchText, onSearch = {
                    searchText = it
                })
                SortByDD(selectedOption, onSelectedOptionChanged = {
                    selectedOption = it
                })
            }
        },
        content = { Content(searchText, selectedOption) }
    )
}

@Composable
fun Content(searchText: String, sortBy: String) {
    val stadiums = when (searchText.isNotEmpty()) {
        true -> StadiumRepo.filterStadiumByName(searchText)
        else -> StadiumRepo.getStadiums(LocalContext.current)
    }
    val sortedStadiums = when (sortBy) {
        SortBy.CITY_NAME -> stadiums.sortedBy { it.city }
        SortBy.SEATING_CAPACITY -> stadiums.sortedBy { it.seatingCapacity }
        SortBy.STADIUM_NAME -> stadiums.sortedBy { it.name }
        else -> stadiums
    }
    StadiumList(stadiums = sortedStadiums)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        MyApp()
    }
}