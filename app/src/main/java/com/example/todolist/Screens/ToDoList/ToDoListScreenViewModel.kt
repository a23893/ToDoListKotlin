package com.example.todolist.Screens.ToDoList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.todolist.DataManager.TaskManager
import com.example.todolist.Model.Task


class ToDoListScreenViewModel : ViewModel() {

    private var _todoList = MutableLiveData<List<Task>>()
    val todoList : LiveData<List<Task>> = _todoList

    fun getAllTasks(){
        _todoList.value = TaskManager.getAllTasks()
    }

    fun addTask(){

    }

    fun deleteTask(id : Int){
        TaskManager.deleteTask(id)
    }
}