package com.example.todolist.Screens

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
fun ToDoListPage(modifier: Modifier = Modifier){

    val taskList = getFakeTask()

    Column (
        modifier =Modifier.fillMaxHeight()
            .padding(8.dp)
    ){
        TaskSearch(onSearchChanged = { query ->
            // Atualizar lista de tarefas filtradas com base na pesquisa
        })

        Spacer(modifier = Modifier.size(10.dp))

        LazyColumn (
            content = {
                itemsIndexed(taskList){index:Int, item: Task ->
                    TaskBox(item = item)
                }
            }
        )

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