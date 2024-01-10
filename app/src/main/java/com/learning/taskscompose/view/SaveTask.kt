package com.learning.taskscompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learning.taskscompose.components.Button
import com.learning.taskscompose.components.TextBox
import com.learning.taskscompose.ui.theme.Purple700
import com.learning.taskscompose.ui.theme.Radio_Button_Green_Disable
import com.learning.taskscompose.ui.theme.Radio_Button_Green_Selected
import com.learning.taskscompose.ui.theme.Radio_Button_Red_Disable
import com.learning.taskscompose.ui.theme.Radio_Button_Red_Selected
import com.learning.taskscompose.ui.theme.Radio_Button_Yellow_Disable
import com.learning.taskscompose.ui.theme.Radio_Button_Yellow_Selected
import com.learning.taskscompose.ui.theme.White

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SaveTask(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Purple700
                ), // This was used instead of backgroundColor property because it doesn't exists at this version
                title = {
                    Text(text = "Save Task", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = White)
                }
            )
        }
    ) {
        var taskTitle by remember {
            mutableStateOf("")
        }

        var taskDescription by remember {
            mutableStateOf("")
        }

        var noPriorityTask by remember {
            mutableStateOf(false)
        }

        var lowPriorityTask by remember {
            mutableStateOf(false)
        }

        var mediumPriorityTask by remember {
            mutableStateOf(false)
        }

        var highPriorityTask by remember {
            mutableStateOf(false)
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            TextBox(
                value = taskTitle,
                onValueChange = { taskTitle = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp, 80.dp, 20.dp, 0.dp), //changed from 20dp to 80dp on top, it was hidden by topBar
                label = "Task title",
                maxLines = 1,
                keyboardType = KeyboardType.Text
            )
            
            TextBox(
                value = taskDescription,
                onValueChange = { taskDescription = it},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp)
                    .padding(20.dp, 10.dp, 20.dp, 0.dp),
                label = "Task Description",
                maxLines = 5,
                keyboardType = KeyboardType.Text
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Priority level")

                RadioButton(
                    selected = lowPriorityTask,
                    onClick = {
                        lowPriorityTask = !lowPriorityTask
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Radio_Button_Green_Disable,
                        selectedColor = Radio_Button_Green_Selected
                    )
                )

                RadioButton(
                    selected = mediumPriorityTask,
                    onClick = {
                        mediumPriorityTask = !mediumPriorityTask
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Radio_Button_Yellow_Disable,
                        selectedColor = Radio_Button_Yellow_Selected
                    )
                )

                RadioButton(
                    selected = highPriorityTask,
                    onClick = {
                        highPriorityTask = !highPriorityTask
                    },
                    colors = RadioButtonDefaults.colors(
                        unselectedColor = Radio_Button_Red_Disable,
                        selectedColor = Radio_Button_Red_Selected
                    )
                )
            }

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth().height(80.dp).padding(20.dp),
                text = "Save task"
            )
        }
    }
}