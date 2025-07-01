package com.example.todolist.Mocks

import com.example.todolist.Model.Step
import com.example.todolist.Model.Task
import java.time.Instant
import java.util.Date

fun getFakeTask(): List<Task> {
    val now = Date.from(Instant.now())

    return listOf(
        Task(
            1,
            "Task 1",
            "Primeira Task",
            now,
            false,
            true,
            now,
            null,
            listOf(
                Step("Passo 1", true, now),
                Step("Passo 2", false)
            )
        ),
        Task(
            2,
            "Task 2",
            "Segunda Task com texto longo",
            now,
            true,
            false,
            now,
            now,
            listOf(
                Step("Planejar", true, now),
                Step("Executar", true, now),
                Step("Revisar", false)
            )
        ),
        Task(
            3,
            "Task 3",
            "Terceira Task",
            now,
            false,
            false,
            now
        ),
        Task(
            4,
            "Task 4",
            "Quarta Task com descrição mais longa",
            now,
            true,
            true,
            now,
            now
        ),
        Task(
            5,
            "Task 4",
            "Quarta Task com descrição mais longa",
            now,
            true,
            true,
            now,
            now
        ),
        Task(
            6,
            "Task 4",
            "Quarta Task com descrição mais longa",
            now,
            true,
            true,
            now,
            now
        ),
        Task(
            7,
            "Task 4",
            "Quarta Task com descrição mais longa",
            now,
            true,
            true,
            now,
            now
        ),
        Task(
            8,
            "Task 4",
            "Quarta Task com descrição mais longa",
            now,
            true,
            true,
            now,
            now
        ),
        Task(
            9,
            "Task 4",
            "Quarta Task com descrição mais longa",
            now,
            true,
            true,
            now,
            now
        ),
        Task(
            10,
            "Task 4",
            "Quarta Task com descrição mais longa",
            now,
            true,
            true,
            now,
            now
        ),
        Task(
            11,
            "Task 4",
            "Quarta Task com descrição mais longa",
            now,
            true,
            true,
            now,
            now
        )

    )
}
