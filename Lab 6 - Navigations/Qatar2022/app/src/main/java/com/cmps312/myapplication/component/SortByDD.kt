package com.cmps312.myapplication.component

import androidx.compose.runtime.Composable
import com.cmps312.myapplication.repository.SortBy

@Composable
fun SortByDD() {
    var sortByOptions = listOf(SortBy.CITY_NAME,
        SortBy.STADIUM_NAME,
        SortBy.SEATING_CAPACITY);


}