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
import com.example.fnd8.components.theProduct
import com.example.fnd8.model.CartItem
import com.example.fnd8.model.User
import com.example.fnd8.pages.CartPage
import com.example.fnd8.pages.DescriptionPage
import com.example.fnd8.pages.Login
import com.example.fnd8.pages.MainPage
import com.example.fnd8.pages.ProductDescription
import com.example.fnd8.pages.Register
import com.example.fnd8.pages.SplashScreen
import com.example.fnd8.screens.Profile
import com.example.fnd8.ui.theme.Fnd8Theme
import com.example.fnd8.viewmodel.UserViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Fnd8Theme {
                 val nav = rememberNavController()
                    NavHost(navController = nav, startDestination = "splash", builder = {
                            composable("login"){
                                Login(nav = nav,theusersViewModel.userViewModel )
                            }
                            composable("splash"){
                                SplashScreen(nav)
                            }
                        composable("register"){
                            Register(nav,theusersViewModel.userViewModel)
                        }
                        composable("main",){
                            MainPage(loggedInUser = logedinuser.user
                             , nav =nav )
                        }
                        composable("cart"){
                            CartPage(nav , logedinuser.user)
                        }
                        composable("product"){
                            DescriptionPage(
                                product = theProduct.product,
                                nav=nav
                            )
                        }
                        composable("profile"){
                            Profile(nav ,theusersViewModel.userViewModel)


                        }
                })
            }
        }
    }
}
object logedinuser{
    lateinit var user :User
}
object theusersViewModel{
    var userViewModel =UserViewModel()
}

