package com.example.todolist.Screens.ToDoList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.Components.FloatingAddButton
import com.example.todolist.Components.TaskBox
import com.example.todolist.Components.TaskSearch
import com.example.todolist.Mocks.Task
import com.example.todolist.Mocks.getFakeTask
import com.example.todolist.ui.theme.ToDoListTheme

@Composable
fun ToDoListPage(modifier: Modifier = Modifier) {

    // Estado do texto search
    var searchQuery by remember { mutableStateOf("") }

    // Lista completa
    val allTasks = remember { getFakeTask() }

    // Lista filtrada
    val filteredTasks = allTasks.filter { task ->
        task.name.contains(searchQuery, ignoreCase = true)
    }

    Column(
        modifier = modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        TaskSearch(onSearchChanged = { query ->
            searchQuery = query
        })

        Spacer(modifier = Modifier.size(10.dp))

        LazyColumn {
            itemsIndexed(filteredTasks) { index: Int, item: Task ->
                TaskBox(item = item)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingAddButton(onClick = { /* ação de adicionar task */ })
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoListPagePreview() {
    ToDoListTheme {
        ToDoListPage()
    }
}