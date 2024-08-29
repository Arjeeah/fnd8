package com.example.fnd8

import androidx.compose.ui.graphics.vector.ImageVector

data class DrawerNav(
    val text: String,
    val selectedIcon : ImageVector,
    val unselectedIcon : ImageVector,
    val route:String
)
