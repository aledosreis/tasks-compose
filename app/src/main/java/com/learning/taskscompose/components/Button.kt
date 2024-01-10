package com.learning.taskscompose.components

import androidx.compose.material3.Text
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.learning.taskscompose.ui.theme.Light_Blue
import com.learning.taskscompose.ui.theme.White

@Composable
fun Button(
    onClick: () -> Unit,
    modifier: Modifier,
    text: String
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = Light_Blue
        ),
    ) {
        Text(text = text, fontWeight = FontWeight.Bold, fontSize = 18.sp)
    }
}