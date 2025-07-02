package com.example.todolist.Navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todolist.Screens.ToDoDetails.TaskDetailPage
import com.example.todolist.Screens.ToDoList.ToDoListPage
import com.example.todolist.Screens.ToDoList.ToDoListScreenViewModel

@Composable
fun AppNavHost(
    viewModel: ToDoListScreenViewModel,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "todo_list",
        modifier = modifier
    ) {
        composable("todo_list") {
            ToDoListPage(
                modifier = Modifier.fillMaxSize(),
                viewModel = viewModel,
                onTaskClick = { taskId ->
                    navController.navigate("task_detail/$taskId")
                }
            )
        }

        composable("task_detail/{taskId}") { backStackEntry ->
            val taskId = backStackEntry.arguments?.getString("taskId")?.toIntOrNull()
            val task = taskId?.let { viewModel.getTaskById(it) }
            if (task != null) {
                TaskDetailPage(task = task, onBack = { navController.popBackStack() })
            } else {
                Text("Tarefa não encontrada.")
            }
        }

    }
}


