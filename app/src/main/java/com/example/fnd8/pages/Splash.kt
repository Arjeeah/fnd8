package com.example.fnd8.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fnd8.R
import com.example.fnd8.components.logoImage
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    var isTimeoutReached by remember { mutableStateOf(false) }

    LaunchedEffect(key1 = true) {
        delay(3000) // Delay for 3 seconds
        isTimeoutReached = true
        onTimeout()
    }

    if (!isTimeoutReached) {
        // Gradient background
        val gradient = Brush.verticalGradient(
            colors = listOf(
                Color(0xFF234F1E), // Dark green
                Color(0xFF387C3B)  // Lighter green
            )
        )

        // Main surface with gradient background
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = gradient),
            color = Color.Transparent // No additional background color
        ) {
            // Centered logo with shadow
            Box(contentAlignment = Alignment.Center) {
                logoImage()
            }
        }
    }
}