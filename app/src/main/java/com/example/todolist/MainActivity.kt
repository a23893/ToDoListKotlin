package com.example.todolist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.todolist.Navigation.AppNavHost
import com.example.todolist.Screens.ToDoList.ToDoListPage
import com.example.todolist.Screens.ToDoList.ToDoListScreenViewModel
import com.example.todolist.ui.theme.ToDoListTheme

class MainActivity : ComponentActivity() {
    private val todoViewModel: ToDoListScreenViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ToDoListTheme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                ) { innerPadding ->
                    AppNavHost(
                        viewModel = todoViewModel,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}




