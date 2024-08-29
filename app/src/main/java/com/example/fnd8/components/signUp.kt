package com.example.fnd8.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.fnd8.R // Adjust the import according to your package structure

@Composable
fun SignUp() {
    Text(text = "Register",
        fontSize = 35.sp,
        color = Color(0xFF234F1E),
        fontWeight = FontWeight.Bold,
        fontFamily = FontFamily(Font(R.font.loginfont)),
        )
//    Text(
//        text = "Register",
//        style = TextStyle(
//            fontSize = 35.sp,
//            color = Color(0xFF234F1E),
//            fontFamily = FontFamily(Font(R.font.loginfont)),
//            fontWeight = FontWeight.Bold
//        )
//    )
}