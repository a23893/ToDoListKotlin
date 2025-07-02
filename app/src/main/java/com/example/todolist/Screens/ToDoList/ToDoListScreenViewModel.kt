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

    fun getTaskById(id: Int): Task? {
        return TaskManager.getAllTasks().find { it.id == id }
    }

    fun addTask(task: Task) {
        TaskManager.addTask(task)
        getAllTasks()  // atualiza a LiveData
    }

    fun updateTask(updatedTask: Task) {
        TaskManager.updateTask(updatedTask)
        getAllTasks()
    }


    fun deleteTask(id : Int){
        TaskManager.deleteTask(id)
        getAllTasks()
    }
}