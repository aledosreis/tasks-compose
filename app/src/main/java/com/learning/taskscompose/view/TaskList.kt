package com.learning.taskscompose.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.learning.taskscompose.R
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

    }
}