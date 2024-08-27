package com.example.fnd8.pages
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.fnd8.R
import com.example.fnd8.components.SignText
import com.example.fnd8.components.logoImage
import com.example.fnd8.components.speacerSmall
import com.example.fnd8.viewmodel.UserViewModel


@SuppressLint("SuspiciousIndentation")
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
                    speacerSmall()
                    SignText()



                }
            }

        }
    }