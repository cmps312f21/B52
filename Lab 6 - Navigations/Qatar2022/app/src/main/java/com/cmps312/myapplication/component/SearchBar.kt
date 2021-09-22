package com.cmps312.myapplication.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.cmps312.myapplication.ui.theme.MyApplicationTheme

//Ayah -> Dark

@Composable
fun SearchBar(searchText: String, onSearch: (String) -> Unit) {
    TextField(
        value = searchText,
        onValueChange = { onSearch(it) },
        modifier = Modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxWidth(),
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search,
                contentDescription = "Search Icon",
                tint = MaterialTheme.colors.secondary)
        },
        trailingIcon = {
            if (searchText.isNotEmpty()) {
                Icon(imageVector = Icons.Default.Close,
                    contentDescription = "Close Icon",
                    tint = MaterialTheme.colors.secondary,
                    modifier = Modifier.clickable { onSearch("") })
            }
        },
        textStyle = TextStyle(MaterialTheme.colors.secondary)

    )
}

@Preview(showBackground = true)
@Composable
fun SearchBarPreview() {
    MyApplicationTheme {
        var searchText by remember { mutableStateOf("") }
        SearchBar(searchText, onSearch = {
            searchText = it
        })
    }

}