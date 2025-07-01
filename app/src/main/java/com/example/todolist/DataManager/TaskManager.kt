package com.example.todolist.DataManager

import com.example.todolist.Model.Task


object TaskManager {

    private val taskList = mutableListOf<Task>()

    fun getAllTasks() : List<Task>{
        return taskList
    }

    fun addTask(task: Task){
        taskList.add(task)
    }

    fun deleteTask(id : Int){
        taskList.removeIf{
            it.id==id
        }
    }
}