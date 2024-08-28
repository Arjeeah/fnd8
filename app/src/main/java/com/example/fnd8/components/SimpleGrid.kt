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
import com.example.fnd8.model.Product
import com.example.fnd8.ui.theme.Fnd8Theme
import com.example.fnd8.R


@Composable
fun SimpleGrid(
    items : MutableList<Product>
) {

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),  // 3 columns in the grid
        modifier = Modifier.padding(16.dp)
    ) {
        items(items) { item ->
            Text(
                text = "Item $item",
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Fnd8Theme {
        val products = mutableListOf<Product>(
            Product(
                title = "Apple",
                type = "fruit",
                price = 2.0,
                description = "high qality apples ",
                image = R.drawable.apple
            )
        )
        ProductCard(
            title = "The Goats Stadium",
            price = "50 LYD/Hour",
            description = "This is a Libyan football stadium located in Alhadayak.",
            imageRes = R.drawable.apple,
            type = "",
        )

    }
}
@Composable
fun ProductCard(
    title: String,
    price: String,
    description: String,
    imageRes: Int,

    type:String
) {
    ElevatedCard(
        modifier = Modifier.clickable {  }
            //.padding(end = 28.dp, start = 10.dp)
           // .height(400.dp)
        //    .width(370.dp)
        ,
        shape = RoundedCornerShape(16.dp),

    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp).background(Color.White),
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
                Text(text = price, fontWeight = FontWeight.Bold)
            }
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
