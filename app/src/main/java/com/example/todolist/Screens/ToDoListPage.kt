package com.example.todolist.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        LazyColumn (
            content = {
                itemsIndexed(taskList){index:Int, item: Task ->
                    Text(text = item.toString())
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoListPagePreview() {
    ToDoListTheme {
        ToDoListPage()
    }
}