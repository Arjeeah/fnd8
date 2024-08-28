package com.example.fnd8.components
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.fnd8.R

@Composable
fun logoImageWhite(
    modifier: Modifier = Modifier.size(250.dp)
){
    Image(
        modifier=modifier,
        painter = painterResource(id = R.drawable.logo_white_removebg), contentDescription = "",

    )
}


