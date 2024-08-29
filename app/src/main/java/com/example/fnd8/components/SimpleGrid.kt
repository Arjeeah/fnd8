package com.example.fnd8.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fnd8.model.Product
import com.example.fnd8.ui.theme.Fnd8Theme
import com.example.fnd8.R


@Composable
fun SimpleGrid(
     list: MutableList<Product>,
     nav: NavController
) {

    var items=list
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),  // 3 columns in the grid
        modifier = Modifier.padding(16.dp)
    ) {
        items(items) { item ->
            ProductCard(title = item.title, price = item.price, description =item.description , imageRes = item.image, type = item.type,nav )
        }
    }
}
@Composable
fun ProductCard(
    title: String,
    price: Double,
    description: String,
    imageRes: Int,
    type:String,
    nav:NavController
)

{
    ElevatedCard(
        modifier = Modifier.clickable {
            theProduct.product=Product(
                title=title,
                price = price,
                description = description,
                image = imageRes,
                type = type,
            )
            nav.navigate("product")
        }
            .padding(top=20.dp,end = 28.dp, start = 10.dp)
        ,
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
                contentScale = ContentScale.Fit,

            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = price.toString()+" $", fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
object  theProduct{
    lateinit var product : Product
}
