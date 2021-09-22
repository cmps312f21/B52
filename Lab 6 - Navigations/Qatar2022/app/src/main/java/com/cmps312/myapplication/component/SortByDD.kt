package com.cmps312.myapplication.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.cmps312.myapplication.repository.SortBy

@Composable
fun SortByDD(selectedOption: String, onSelectedOptionChanged: (String) -> Unit) {

    var sortByOptions = listOf(SortBy.CITY_NAME,
        SortBy.STADIUM_NAME,
        SortBy.SEATING_CAPACITY);

    var expanded by remember { mutableStateOf(false) }

    Column() {
        Row() {
            Icon(imageVector = Icons.Default.ArrowDropDown,
                contentDescription = "Sort DropDown",
                modifier = Modifier.clickable { expanded = !expanded }
            )
            Text(text = selectedOption)
        }
        DropdownMenu(expanded = expanded,
            onDismissRequest = { /*TODO*/ }) {

            sortByOptions.forEach { option ->
                DropdownMenuItem(onClick = {
                    expanded = false
                    onSelectedOptionChanged(option)
                }) {
                    Text(text = option)
                }
            }

        }
    }
}