package com.example.educationsdg4app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*
import com.example.educationsdg4app.screens.*

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppNavigation()
        }
    }
}

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    // ✅ 创建 ViewModel（整个App共享）
    val viewModel: EducationViewModel = viewModel()

    MaterialTheme {

        NavHost(
            navController = navController,
            startDestination = "home"
        ) {

            // 🏠 Home
            composable("home") {
                HomeScreen(navController)
            }

            // 📝 Input
            composable("input") {
                InputScreen(navController, viewModel)
            }

            // 🧮 Calculation（如果你有这个页面）
            composable("calculation") {
                CalculationScreen(navController)
            }

            // 📊 Summary
            composable("summary") {
                SummaryScreen(viewModel)
            }

            // 📄 Detail
            composable("detail") {
                DetailScreen(viewModel)
            }
        }
    }
}