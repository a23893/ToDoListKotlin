package com.example.todolist.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolist.Model.Task
import com.example.todolist.R
import java.text.SimpleDateFormat
import java.time.Instant
import java.util.Date
import java.util.Locale

@Composable
fun TaskBox(
    item: Task,
    onDelete: (Int) -> Unit // novo parâmetro
) {
    var isChecked by remember { mutableStateOf(item.checked) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.primary)
            .padding(16.dp)
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = {
                isChecked = it
                // Aqui você também pode acionar uma função para atualizar o status no ViewModel
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Color(0xFF4CAF50),
                checkmarkColor = Color.White,
                uncheckedColor = Color.Gray
            )
        )

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = SimpleDateFormat("HH:mm, dd/MM", Locale.ENGLISH).format(item.createdAt),
                fontSize = 10.sp,
                color = Color.LightGray
            )
            Text(
                text = item.name,
                fontSize = 20.sp,
                color = Color.White
            )
        }

        IconButton(onClick = {
            onDelete(item.id) // <- chama a função passada
        }) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_delete_24),
                contentDescription = "Delete icon",
                tint = Color.White
            )
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//fun TaskBoxPreview() {
//    TaskBox(Task(1, "Task 1", "Primeira Task", Date.from(Instant.now()), false, true, Date.from(
//        Instant.now())),)
//}