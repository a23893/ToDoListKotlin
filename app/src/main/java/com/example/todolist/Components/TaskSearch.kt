package com.example.todolist.Components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TaskSearch(
    modifier: Modifier = Modifier,
    onSearchChanged: (String) -> Unit = {}
) {
    var searchText by remember { mutableStateOf("") }

    OutlinedTextField(
        value = searchText,
        onValueChange = {
            searchText = it
            onSearchChanged(it)
        },
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .padding(8.dp),
        placeholder = { Text("Search Task...") },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = "Ícone de busca")
        },
        singleLine = true
    )
}

@Preview(showBackground = true)
@Composable
fun TaskSearchPreview() {
    TaskSearch()
}
