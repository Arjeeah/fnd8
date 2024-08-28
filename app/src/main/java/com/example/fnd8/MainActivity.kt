package com.example.fnd8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.composable
import com.example.fnd8.model.CartItem
import com.example.fnd8.model.User
import com.example.fnd8.pages.Login
import com.example.fnd8.pages.MainPage
import com.example.fnd8.pages.Register
import com.example.fnd8.pages.SplashScreen
import com.example.fnd8.ui.theme.Fnd8Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Fnd8Theme {
                  val nav = rememberNavController()
                    NavHost(navController = nav, startDestination = "main", builder = {
                            composable("login"){
                                Login(nav = nav, )
                            }
                            composable("splash"){
                                SplashScreen({})
                            }
                        composable("register"){
                            Register(nav)
                        }
                        composable("main"){
                            MainPage(loggedInUser = User(
                                userName = "ali",
                                userPhone = "098",
                                userPassword = "098",
                                userCart = null
                            ) , nav =nav )
                        }

                    })
            }
        }
    }
}

