package com.example.educationsdg4app.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.educationsdg4app.EducationRecord
import com.example.educationsdg4app.EducationViewModel

@Composable
fun DetailScreen(viewModel: EducationViewModel) {

    // ✅ 关键修复：StateFlow → Compose State
    val records by viewModel.records.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        items(records) { record ->
            DetailItem(record)
        }
    }
}

@Composable
fun DetailItem(record: EducationRecord) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {

        Text(text = "Name: ${record.studentName}")
        Text(text = "Course: ${record.course}")
        Text(text = "Study Hours: ${record.studyHours}")
        Text(text = "Progress: ${record.progress}%")

    }
}