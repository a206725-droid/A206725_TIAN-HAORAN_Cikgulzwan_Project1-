package com.example.educationsdg4app.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Text("SDG4 Quality Education")

        Button(onClick = { navController.navigate("input") }) {
            Text("Add Record")
        }

        Button(onClick = { navController.navigate("summary") }) {
            Text("View Summary")
        }

        Button(onClick = { navController.navigate("calculation") }) {
            Text("Calculation")
        }
    }
}