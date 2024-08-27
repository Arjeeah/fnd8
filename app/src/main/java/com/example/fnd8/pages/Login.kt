package com.example.fnd8.pages
import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
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
import com.example.fnd8.components.speacer32
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
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    logoImage()
                    speacer32()
                    SignText()
                    speacer32()
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(300.dp)
                            .padding(bottom = 15.dp, start = 25.dp, end = 25.dp)
                            .background(Color.White, shape = RoundedCornerShape(24.dp))
                    ){
                        Column(
                            Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceEvenly
                        ) {
                            OutlinedTextField(
                                value = "", onValueChange ={} ,
                                shape = RoundedCornerShape(24.dp),
                                label = { Text(text = "Phone")}
                            )
                            OutlinedTextField(
                                value = "", onValueChange ={} ,
                                shape = RoundedCornerShape(24.dp),

                                label = { Text(text = "Password")},
                            )
                        }
                    }
                    Text(
                        text = "Create new  account ",
                        Modifier.clickable { },
                        style = TextStyle(
                            fontSize = 20.sp,
                            color = Color.White,
                            fontFamily =  FontFamily(Font(R.font.loginfont)),
                            fontWeight = FontWeight.Bold
                        )
                    )




                }
            }

        }
    }