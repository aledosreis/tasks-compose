package com.learning.taskscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.learning.taskscompose.ui.theme.TasksComposeTheme
import com.learning.taskscompose.view.SaveTask
import com.learning.taskscompose.view.TaskList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TasksComposeTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "taskList") {
                    composable(
                        route = "taskList"
                    ) {
                        TaskList(navController)
                    }

                    composable(
                        route = "saveTask"
                    ) {
                        SaveTask(navController)
                    }
                }
            }
        }
    }
}