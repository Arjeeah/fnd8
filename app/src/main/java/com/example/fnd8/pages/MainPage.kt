package com.example.fnd8.pages

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.ExitToApp
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fnd8.DrawerNav
import com.example.fnd8.R
import com.example.fnd8.components.logoImage
import com.example.fnd8.components.logoImageWhite
import com.example.fnd8.components.speacerSmall
import com.example.fnd8.model.User
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainPage(loggedInUser: User,nav:NavController){
    val itemsNavigation = listOf(
        DrawerNav(
            text = "Profile",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
        ),
        DrawerNav(
            text = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
        ),
        DrawerNav(
            text = "About Fnd8n",
            selectedIcon = Icons.Filled.Info,
            unselectedIcon = Icons.Outlined.Info,
        ),
        DrawerNav(
            text = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
        ),
        DrawerNav(
            text = "Log Out",
            selectedIcon = Icons.Filled.ExitToApp,
            unselectedIcon = Icons.Outlined.ExitToApp,
        ),
    )



    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    var selectedNavigationItemIndex by rememberSaveable {
        mutableStateOf(0)
    }
    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet {
                Spacer(modifier = Modifier.height(16.dp))
                itemsNavigation.forEachIndexed { index, item ->
                    NavigationDrawerItem(
                        label = {
                            Text(text = item.text)
                        },
                        selected = index == selectedNavigationItemIndex,
                        onClick = {
                            selectedNavigationItemIndex = index
                            scope.launch {
                                drawerState.close()
                            }
                            if(selectedNavigationItemIndex == 2){

                                nav.navigate("info")
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = if (index == selectedNavigationItemIndex) {
                                    item.selectedIcon
                                } else item.unselectedIcon,
                                contentDescription = item.text
                            )
                        },
                        modifier = Modifier
                            .padding(NavigationDrawerItemDefaults.ItemPadding)) } } },
        drawerState = drawerState
    ){
        Scaffold (
            topBar = {TopAppBar(
                modifier = Modifier.height(110.dp),
                title = {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp), // Optional padding to avoid touching edges
                        contentAlignment = Alignment.TopStart
                    ) {
                        logoImageWhite(
                            Modifier
                                .size(400.dp)
                                .padding(end = 40.dp))
                    }
                },

                navigationIcon = {
                    IconButton(onClick = {
                        scope.launch {
                            drawerState.open()
                        }

                    }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }

            )
            }
        ){innerPadding ->
            val scrollState = rememberScrollState()
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
            ) {
//

                Box (
                    Modifier
                        .fillMaxWidth()
                ){
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .horizontalScroll(enabled = true, state = scrollState)
                    ) {
                        Text(
                            text = " vegetables ",
                            style = TextStyle(
                                fontSize = 21.sp,
                                color = Color(0xff173844),
                                fontFamily = FontFamily(Font(R.font.category_name)),
                            ),
                            modifier = Modifier.clickable {  }
                        )
                        Text(
                            text = " fruit ",
                            style = TextStyle(
                                fontSize = 21.sp,
                                color = Color(0xff173844),
                                fontFamily = FontFamily(Font(R.font.category_name)),
                            ),
                            modifier = Modifier.clickable {  }
                        )
                        Text(
                            text = " Leaves  ",
                            style = TextStyle(
                                fontSize = 21.sp,
                                color = Color(0xff173844),
                                fontFamily = FontFamily(Font(R.font.category_name)),
                            ),
                            modifier = Modifier.clickable {  }
                        )
                        Text(
                            text = " Honey ",
                            style = TextStyle(
                                fontSize = 21.sp,
                                color = Color(0xff173844),
                                fontFamily = FontFamily(Font(R.font.category_name)),
                            ),
                            modifier = Modifier.clickable {  }
                        )
                        Text(
                            text = " Roots ",
                            style = TextStyle(
                                fontSize = 21.sp,
                                color = Color(0xff173844),
                                fontFamily = FontFamily(Font(R.font.category_name)),
                            ),
                            modifier = Modifier.clickable {  }
                        )
                        Text(
                            text = " Flowers ",
                            style = TextStyle(
                                fontSize = 21.sp,
                                color = Color(0xff173844),
                                fontFamily = FontFamily(Font(R.font.category_name)),
                            ),
                            modifier = Modifier.clickable {  }
                        )
                    }
                }

            }

        }
    }

}

