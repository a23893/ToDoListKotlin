package com.example.todolist.DataManager

import com.example.todolist.Model.Task


object TaskManager {

    private val taskList = mutableListOf<Task>()

    fun getAllTasks(): List<Task> {
        return taskList.toList() // força recomposição
    }

    fun addTask(task: Task) {
        taskList.add(task)
    }

    fun updateTask(updatedTask: Task) {
        val index = taskList.indexOfFirst { it.id == updatedTask.id }
        if (index != -1) {
            taskList[index] = updatedTask
        }
    }

    fun deleteTask(id: Int) {
        taskList.removeIf { it.id == id }
    }
}
