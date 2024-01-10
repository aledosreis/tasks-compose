package com.learning.taskscompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learning.taskscompose.R
import com.learning.taskscompose.listItem.TaskItem
import com.learning.taskscompose.model.Task
import com.learning.taskscompose.ui.theme.Black
import com.learning.taskscompose.ui.theme.Purple700
import com.learning.taskscompose.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskList(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Purple700
                ), // This was used instead of backgroundColor property because it doesn't exists at this version
                title = {
                    Text(text = "Task List", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = White)
                }
            )
        },
        containerColor = Black, // This was used instead of backgroundColor property because it doesn't exists at this version
        floatingActionButton = {
          FloatingActionButton(
              onClick = {
                        navController.navigate("saveTask")
              },
              containerColor = Purple700
          ) {
              Image(
                  imageVector = ImageVector.vectorResource(id = R.drawable.ic_add), //This image was used instead of add_icon because this was not found on asset studio
                  contentDescription = "Icon for save task"
              )
          }
        },
    ) {
        val taskList: MutableList<Task> = mutableListOf(
            Task(
                title = "Play soccer",
                description = "Play soccer today",
                priorityLevel = 0
            ),

            Task(
                title = "Go to cinema",
                description = "Watch some movie today",
                priorityLevel = 1
            ),

            Task(
                title = "Go to school",
                description = "Need to study",
                priorityLevel = 2
            ),

            Task(
                title = "Task 4",
                description = "New task",
                priorityLevel = 3
            )
        )

        LazyColumn(
            modifier = Modifier.padding(0.dp, 80.dp, 0.dp, 0.dp) // added because was hidden by topBar
        ) {
            itemsIndexed(taskList) { position, _ ->
                TaskItem(position, taskList)
            }
        }
    }
}