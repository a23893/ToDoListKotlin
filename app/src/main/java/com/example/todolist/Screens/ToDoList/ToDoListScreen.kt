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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolist.Components.FloatingAddButton
import com.example.todolist.Components.Modals.AddTaskModal
import com.example.todolist.Components.TaskBox
import com.example.todolist.Components.TaskSearch
import com.example.todolist.DataManager.TaskManager
import com.example.todolist.Mocks.getFakeTask
import com.example.todolist.ui.theme.ToDoListTheme

@Composable
fun ToDoListPage(modifier: Modifier = Modifier, viewModel: ToDoListScreenViewModel) {

    // * IMPLEMENTAÇAO USANDO MOCKS *
    // Estado do texto search
    //var searchQuery by remember { mutableStateOf("") }

    // Lista completa (mocks)
    //val allTasks = remember { getFakeTask() }

    // Lista filtrada
    //val filteredTasks = allTasks.filter {
    //    it.name.contains(searchQuery, ignoreCase = true)
    //}

    // Estado do modal
    //var showAddModal by remember { mutableStateOf(false) }
    // * FIM *

    var searchQuery by remember { mutableStateOf("") }
    val allTasks by viewModel.todoList.observeAsState(initial = emptyList())

    // Filtra a lista com base no texto digitado
    val filteredTasks = allTasks.filter {
        it.name.contains(searchQuery, ignoreCase = true)
    }

    var showAddModal by remember { mutableStateOf(false) }

    // Carrega as tarefas quando o Composable for exibido
    LaunchedEffect(Unit) {
        viewModel.getAllTasks()
    }

    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            TaskSearch(onSearchChanged = { query ->
                searchQuery = query
            })

            Spacer(modifier = Modifier.size(10.dp))

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                itemsIndexed(filteredTasks) { index, item ->
                    TaskBox(
                        item = item,
                        onDelete = { id ->
                            viewModel.deleteTask(id)
                            viewModel.getAllTasks() // força atualizar
                        }
                    )
                }
            }
        }

        // Botão de adicionar
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            FloatingAddButton(onClick = { showAddModal = true })
        }

        // Modal de adicionar
        if (showAddModal) {
            AddTaskModal(
                onDismiss = { showAddModal = false },
                onAddTask = { newTask ->
                    TaskManager.addTask(newTask)
                    viewModel.getAllTasks() // Atualiza lista ao adicionar
                    showAddModal = false
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ToDoListPagePreview() {
    ToDoListTheme {
        //ToDoListPage()
    }
}