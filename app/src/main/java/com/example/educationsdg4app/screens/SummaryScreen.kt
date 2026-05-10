package com.example.educationsdg4app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.educationsdg4app.EducationViewModel

@Composable
fun SummaryScreen(viewModel: EducationViewModel) {

    // ✅ 关键修复
    val records by viewModel.records.collectAsState()

    val totalStudents = records.size
    val totalHours = records.sumOf { it.studyHours }
    val avgProgress =
        if (records.isNotEmpty()) records.sumOf { it.progress } / records.size else 0

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {

        Text(text = "Total Students: $totalStudents")
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Total Study Hours: $totalHours")
        Spacer(modifier = Modifier.height(8.dp))

        Text(text = "Average Progress: $avgProgress%")

    }
}