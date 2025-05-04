package com.example.todolist.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.Mocks.Task
import com.example.todolist.Mocks.getFakeTask
import com.example.todolist.ui.theme.ToDoListTheme
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale

@Composable
fun TaskBox(item: Task){

    Row (
        modifier = Modifier.fillMaxWidth()
            .padding(8.dp)

    ){

        Column {

            Text(text = SimpleDateFormat("HH:mm:aa, dd/mm", Locale.ENGLISH).format(item.createdAt))

            Text(text = item.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskBoxPreview() {
    TaskBox(Task(1, "Task 1", "Primeira Task", Date.from(Instant.now()), false, true, Date.from(
        Instant.now())),)
}