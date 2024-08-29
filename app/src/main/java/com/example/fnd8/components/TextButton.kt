package com.example.fnd8.componets

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.core.app.NotificationCompat.Style

@Composable
fun TextButton(
    text: String,
    onClick: () -> Unit
) {
    Text(
        modifier = Modifier.clickable { onClick },
            text = text,
        style= TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
            color = Color.Red,
            ),

    )
}