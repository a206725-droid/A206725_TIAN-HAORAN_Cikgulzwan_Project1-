package com.example.educationsdg4app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.educationsdg4app.EducationRecord
import com.example.educationsdg4app.EducationViewModel   // ✅ 必须有这个

@Composable
fun InputScreen(navController: NavController, viewModel: EducationViewModel) {

    var name by remember { mutableStateOf("") }
    var course by remember { mutableStateOf("") }
    var hours by remember { mutableStateOf("") }
    var progress by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = course,
            onValueChange = { course = it },
            label = { Text("Course") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = hours,
            onValueChange = { hours = it },
            label = { Text("Study Hours") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        TextField(
            value = progress,
            onValueChange = { progress = it },
            label = { Text("Progress (%)") }
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {

            val h = hours.toIntOrNull() ?: 0
            val p = progress.toIntOrNull() ?: 0

            // ✅ 正确写法
            viewModel.addRecord(
                EducationRecord(
                    studentName = name,
                    course = course,
                    studyHours = h,
                    progress = p
                )
            )

            // 👉 跳转到 summary
            navController.navigate("summary")

        }) {
            Text("Save")
        }
    }
}