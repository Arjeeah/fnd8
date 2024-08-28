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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.example.fnd8.R
import com.example.fnd8.components.SignText
import com.example.fnd8.components.logoImage
import com.example.fnd8.components.logoImageWhite
import com.example.fnd8.components.speacer32
import com.example.fnd8.components.speacerSmall
import com.example.fnd8.viewmodel.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun Login(
        nav:NavController,
        UserViewModel:UserViewModel = UserViewModel(),
        ){
    var phone = rememberSaveable {
        mutableStateOf("")
    }
    var password = rememberSaveable {
        mutableStateOf("")
    }

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
                    .background(Color.White)
            ){

                Column(
                    Modifier
                        .fillMaxSize()
                        .padding(top = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    logoImageWhite()
                    speacer32()
                    SignText()
                    speacer32()
                    Box(
                        Modifier
                            .fillMaxWidth()
                            .height(350.dp)
                            .padding(bottom = 15.dp, start = 25.dp, end = 25.dp)
                            .background(Color(0xFF234F1E), shape = RoundedCornerShape(24.dp))
                    ){
                        Column(
                            Modifier
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.SpaceAround,
                        ) {
                            OutlinedTextField(
                                modifier = Modifier.padding(10.dp),
                                value = phone.value, onValueChange ={phone.value=it} ,
                                shape = RoundedCornerShape(24.dp),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color.White,        // Outline color when focused
                                    unfocusedBorderColor = Color.White,      // Outline color when not focused
                                    containerColor = Color.White,      // Field (background) color
                                    cursorColor = Color(0xFF387C3B),                // Cursor color
                                    focusedLabelColor = Color.White,     // Label color when focused
                                    unfocusedLabelColor = Color.Gray    // Label color when not focused
                                ),

                                label = { Text(text = "Phone")},

                            )
                            OutlinedTextField(
                                value = password.value, onValueChange ={password.value=it} ,
                                shape = RoundedCornerShape(24.dp),
                                visualTransformation = PasswordVisualTransformation(),
                                colors = TextFieldDefaults.outlinedTextFieldColors(
                                    focusedBorderColor = Color.White,        // Outline color when focused
                                    unfocusedBorderColor = Color.White,      // Outline color when not focused
                                    containerColor = Color.White,      // Field (background) color
                                    cursorColor = Color(0xFF387C3B),                // Cursor color
                                    focusedLabelColor = Color.White,     // Label color when focused
                                    unfocusedLabelColor = Color.Gray    // Label color when not focused
                                ),
                                label = { Text(text = "Password")},
                            )
                            OutlinedButton(
                                onClick = { /*TODO*/ },
                                colors = ButtonDefaults.buttonColors(
                                    containerColor = Color.White,
                                    contentColor = Color(0xff173844),
                                    ),
                                modifier = Modifier.width(120.dp)
                            )
                            {
                                Text(text = "Log In")
                            }
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