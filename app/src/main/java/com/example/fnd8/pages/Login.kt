package com.example.fnd8.pages
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.fnd8.R
import com.example.fnd8.components.logoImage
import com.example.fnd8.viewmodel.UserViewModel


@Composable
fun Login(
        nav:NavController,
        UserViewModel:UserViewModel = UserViewModel(),
        ){
    val gradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF234F1E), // Dark green
            Color(0xFF387C3B)  // Lighter green
        )
    )
        Scaffold(
            Modifier
        ) {innerPadding ->
            print(innerPadding)
            Box (
                Modifier
                    .fillMaxSize()
                    .background(brush = gradient)
            ){

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    logoImage()


                }
            }

        }
    }