package com.example.fnd8.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.fnd8.R

@Composable
fun SignText(){
    Text(
        text = "Sign In", style = TextStyle(
        fontSize = 50.sp,
        color = Color.White,
        fontFamily =  FontFamily(Font(R.font.loginfont)),
        fontWeight = FontWeight.Bold
         )
    )
}