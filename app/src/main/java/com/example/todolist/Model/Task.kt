package com.example.todolist.Model

import java.util.Date

data class Step(
    var name: String,
    var isDone: Boolean,
    var completedAt: Date? = null
)

data class Task(
    var id: Int,
    var name: String,
    var description: String,
    var createdAt: Date,
    var checked: Boolean,
    var star: Boolean,
    var expectedEndDate: Date,
    var completedAt: Date? = null,
    var steps: List<Step> = listOf(),
    var stepsDone: Int? = null,
    var stepsTotal: Int? = null,
)