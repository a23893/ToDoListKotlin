package com.example.todolist.Mocks

import java.time.Instant
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
