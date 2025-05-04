package com.example.todolist.Mocks

import java.time.Instant
import java.util.Date

class Task(
    var id: Int,
    var name: String,
    var description: String,
    //var createdAt: Timestamp,
    var createdAt: Date,
    var checked: Boolean,
    var star: Boolean,
    var endDate: Date,
)

fun getFakeTask() : List<Task>{
    return listOf<Task>(
        Task(1, "Task 1", "Primeira Task", Date.from(Instant.now()), false, true, Date.from(Instant.now())),
        Task(2, "Task 2", "Segunda Task dkaçldkaldasjdlkjskd djada dd akdajd ka", Date.from(Instant.now()), true, false, Date.from(Instant.now())),
        Task(3, "Task 3", "Terceira Task", Date.from(Instant.now()), false, false, Date.from(Instant.now())),
        Task(4, "Task 4", "Quarta Task dkaldj ejdjkdknwdnsknda", Date.from(Instant.now()), true, true, Date.from(Instant.now()))
    )
}