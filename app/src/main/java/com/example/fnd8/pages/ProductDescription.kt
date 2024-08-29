package com.example.fnd8.pages

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fnd8.R
import com.example.fnd8.components.ProductCard
import com.example.fnd8.logedinuser
import com.example.fnd8.model.CartItem
import com.example.fnd8.model.Product
import com.example.fnd8.ui.theme.Fnd8Theme
import com.example.fnd8.viewmodel.UserViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescriptionPage(
    nav:NavController,
    product: Product,
){
    Scaffold(
        topBar ={ TopAppBar(
            title = {
                IconButton(onClick = { nav?.popBackStack() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "")
                }
                Box(
                    Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.BottomCenter,
                ) {
                    Text(text = "Product")
                }
            },

            )}
    ) {p ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(vertical = 50.dp)
                .padding(p),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            ProductDescription(
                product,
                nav
            )
            Button(
                onClick = { logedinuser.user.userCart?.add(
                    CartItem(
                        product,
                        2
                    )
                ) },
                Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff173844),
                    contentColor = Color(0xff173844),
                    ),
                ) {
                Text(text = "Add to Cart", color = Color.White)
            }
        }
    }
}
 @Composable
fun ProductDescription(
    Prduct:Product,
    nav: NavController
){

     StadiumCard(
         title = Prduct.title,
         price = Prduct.price,
         description =Prduct.description,
         imageRes = Prduct.image
     )
}
@Composable
fun StadiumCard(
    title: String,
    price: Double,
    description: String,
    imageRes: Int
) {
    Card(
        modifier = Modifier
            .padding(end = 28.dp, start = 10.dp)
            .height(400.dp)
            .width(370.dp)
            .background(Color.White),
            colors = CardDefaults.cardColors(
                containerColor = Color(0xFF234F1E),
                contentColor = Color.White
            ),
        shape = RoundedCornerShape(16.dp),

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(Color.White),
                contentScale = ContentScale.Fit
            )
            Column (
                Modifier.padding(15.dp)
            ){
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = title,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "$price $ per kilo", fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = description,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
