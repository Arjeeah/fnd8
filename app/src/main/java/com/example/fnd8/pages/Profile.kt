package com.example.fnd8.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fnd8.R
import com.example.fnd8.componets.DefaultButton
import com.example.fnd8.componets.InformationCard
import com.example.fnd8.componets.ProfileAvatar
import com.example.fnd8.componets.SpaceHorizontal16
import com.example.fnd8.componets.SpaceVertical24
import com.example.fnd8.componets.SpaceVertical32
import com.example.fnd8.componets.TextButton
import com.example.fnd8.logedinuser
import com.example.fnd8.logedinuser.user
import com.example.fnd8.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Profile(
    nav:NavController,
    viewModel : UserViewModel = UserViewModel(),
){
    Scaffold(
        topBar = {TopAppBar(title = {
            IconButton(onClick = {nav.popBackStack() }) {
                Icon(Icons.Filled.ArrowBack, contentDescription ="" )
            }
        })}
    ) {p ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .padding(p),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            SpaceVertical32()

            ProfileAvatar(
                painter = painterResource(id = R.drawable.logo),
                size = 128
            )
            SpaceVertical24()

            TextButton(text = "Change Profile Picture") {}
            SpaceVertical32()
            Row(modifier = Modifier.fillMaxWidth()) {
                Box(modifier = Modifier.weight(1F)) {
                    InformationCard(
                        title = logedinuser.user.userName,
                        information = "",
                        onTextChange = {

                        }
                    )
                }
                SpaceHorizontal16()
                Box(modifier = Modifier.weight(1F)) {
                    InformationCard(
                        title = logedinuser.user.userName,
                        information = "user[0].secondName",
                        onTextChange = {

                        }
                    )
                }
            }
            InformationCard(
                title = "Location",
                information = "Benghazi",
                onTextChange = {
                }
            )
            InformationCard(
                title = "Phone",
                information = user.userPhone,
                onTextChange = {
                }
            )
            DefaultButton(buttonText = "Save", onClick = {})
        }
    }
}
