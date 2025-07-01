package com.example.todolist.Components.Modals

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.todolist.Components.DatePickerDialog
import com.example.todolist.Model.Step
import com.example.todolist.Model.Task
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun AddTaskModal(
    onDismiss: () -> Unit,
    onAddTask: (Task) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var expectedEndDate by remember { mutableStateOf(Date()) }

    val steps = remember { mutableStateListOf<Step>() }

    var showDatePicker by remember { mutableStateOf(false) }

    Dialog(onDismissRequest = { onDismiss() }) {
        Surface(
            shape = MaterialTheme.shapes.medium,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("New Task")

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = name,
                    onValueChange = { name = it },
                    label = { Text("Name") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable { showDatePicker = true }
                ) {
                    Text("Expected Date: ${SimpleDateFormat("dd/MM/yyyy").format(expectedEndDate)}")
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(Icons.Default.DateRange, contentDescription = "Pick Date")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text("Steps")
                Spacer(modifier = Modifier.height(8.dp))

                steps.forEachIndexed { index, step ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        OutlinedTextField(
                            value = step.name,
                            onValueChange = { newName ->
                                steps[index] = step.copy(name = newName)
                            },
                            modifier = Modifier.weight(1f),
                            label = { Text("Step") }
                        )
                        IconButton(onClick = {
                            steps.removeAt(index)
                        }) {
                            Icon(Icons.Default.Delete, contentDescription = "Remove Step")
                        }
                    }
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                    steps.add(Step(name = "", isDone = false))
                }) {
                    Text("Add Step")
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = { onDismiss() }) {
                        Text("Cancel")
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Button(
                        onClick = {
                            val newTask = Task(
                                id = (0..100000).random(),
                                name = name,
                                description = description,
                                createdAt = Date(),
                                checked = false,
                                star = false,
                                expectedEndDate = expectedEndDate,
                                steps = steps.toList(),
                                stepsDone = steps.count { it.isDone },
                                stepsTotal = steps.size
                            )
                            onAddTask(newTask)
                        },
                        enabled = name.isNotBlank()
                    ) {
                        Text("Add Task")
                    }
                }
            }
        }
    }

    if (showDatePicker) {
        DatePickerDialog(
            initialDate = expectedEndDate,
            onDateSelected = {
                expectedEndDate = it
                showDatePicker = false
            },
            onDismiss = {
                showDatePicker = false
            }
        )
    }
}
