package com.example.fnd8.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.times
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.times
import androidx.navigation.NavController
import com.example.fnd8.components.ProductList
import com.example.fnd8.model.CartItem
import com.example.fnd8.model.Product
import com.example.fnd8.model.User
import com.example.fnd8.ui.theme.Fnd8Theme
import com.example.fnd8.viewmodel.UserViewModel
import kotlin.time.times

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CartPage(
    nav: NavController,
    loggedInUser : Int,
    UserViewModel: UserViewModel,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    IconButton(onClick = {nav.popBackStack() }) {
                       Icon(Icons.Filled.ArrowBack, contentDescription ="" )
                    }
                    Box(
                        Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.BottomCenter
                        ) {
                            Text(text = "Cart")
                    }
                }
            )
        }
    ) {p ->

        Column(
            Modifier
                .fillMaxSize()
                .padding(p)
        ) {
            UserViewModel.users[loggedInUser].userCart?.forEachIndexed(){ index ,cartItem ->
                CartElement(
                    cartItem,
                    add = {
                          cartItem.quntity++
                    },
                    remove = {
                        cartItem.quntity--
                    }
                )
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Fnd8Theme {
//        CartPage(
//
//        )
//    }
//}

@Composable
fun CartElement(
    cartItem: CartItem,
    modifier: Modifier = Modifier,
    add:()->Unit,
    remove:()->Unit
) {
    Card(
        elevation = CardDefaults.cardElevation(15.dp),
        modifier = modifier,
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        )
    ) {
        Row {
            Image( painter = painterResource(id = cartItem.product.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(5.dp)
                    .weight(1f),
                contentScale = ContentScale.Inside
            )
            Spacer(modifier = Modifier.width(5.dp))
            Column(
                modifier = Modifier
                    .weight(2f)
                    .padding(5.dp)
            ) {
                Text(
                    text = cartItem.product.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "$${cartItem.product.price}",
                    color = Color.Black,
                    fontSize = 18.sp,
                    maxLines = 3,
                    fontWeight = FontWeight.Light
                )
                Spacer(modifier = Modifier.height(5.dp))
                Row {
                    var x = mutableSetOf(cartItem.quntity)
                    Text(
                        modifier = Modifier,
                        textAlign = TextAlign.Center,
                        text = "$x kilo",
                        color = Color.Black,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.width(75.dp))
                    IconButton(onClick = remove) {
                        Icon(Icons.Filled.KeyboardArrowLeft, contentDescription ="" )
                    }
                    IconButton(onClick = add) {
                        Icon(Icons.Filled.KeyboardArrowRight, contentDescription ="" )
                    }
                }
            }
        }
    }
}
