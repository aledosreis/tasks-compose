package com.learning.taskscompose.listItem

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.learning.taskscompose.R
import com.learning.taskscompose.model.Task
import com.learning.taskscompose.ui.theme.Black
import com.learning.taskscompose.ui.theme.Radio_Button_Green_Selected
import com.learning.taskscompose.ui.theme.Radio_Button_Red_Selected
import com.learning.taskscompose.ui.theme.Radio_Button_Yellow_Selected
import com.learning.taskscompose.ui.theme.ShapeCardPriority
import com.learning.taskscompose.ui.theme.White

@Composable
fun TaskItem(
    position: Int,
    taskList: MutableList<Task>
) {
    val taskTitle = taskList[position].title
    val taskDescription = taskList[position].description
    val taskPriority = taskList[position].priorityLevel

    val priorityLevel: String = when(taskPriority) {
        0 -> "No Priority"
        1 -> "Low Priority"
        2 -> "Medium Priority"
        else -> "High Priority"
    }

    val colorPriority = when(taskPriority) {
        0 -> Black
        1 -> Radio_Button_Green_Selected
        2 -> Radio_Button_Yellow_Selected
        else -> Radio_Button_Red_Selected
    }

    Card(
        colors = CardDefaults.cardColors(
            containerColor = White
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        ConstraintLayout(
            modifier = Modifier.padding(20.dp)
        ) {

            val (txtTitle, txtDescription, cardPriority, txtPriority, btnDelete) = createRefs()

            Text(
                text = taskTitle.toString(),
                modifier = Modifier.constrainAs(txtTitle) {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = taskDescription.toString(),
                modifier = Modifier.constrainAs(txtDescription) {
                    top.linkTo(txtTitle.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                }
            )

            Text(
                text = priorityLevel,
                modifier = Modifier.constrainAs(txtPriority) {
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            )

            Card(
                colors = CardDefaults.cardColors(
                    containerColor = colorPriority
                ),
                modifier = Modifier
                    .size(30.dp)
                    .constrainAs(cardPriority) {
                        top.linkTo(txtDescription.bottom, margin = 10.dp)
                        start.linkTo(txtPriority.end, margin = 10.dp)
                        bottom.linkTo(parent.bottom, margin = 10.dp)
                    },
                shape = ShapeCardPriority.large
            ) {}

            IconButton(
                onClick = {},
                modifier = Modifier.constrainAs(btnDelete) {
                    top.linkTo(txtDescription.bottom, margin = 10.dp)
                    start.linkTo(cardPriority.end, margin = 30.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                    bottom.linkTo(parent.bottom, margin = 10.dp)
                }
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(id = R.drawable.ic_delete),
                    contentDescription = null
                )
            }
        }
    }
}