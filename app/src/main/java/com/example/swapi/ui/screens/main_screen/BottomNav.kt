package com.example.swapi.ui.screens.main_screen

//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.foundation.background
import androidx.compose.material.*
import androidx.compose.material3.MaterialTheme
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNav(navController: NavHostController) {
    val itemList = listOf(
        BottomNavItem.HomeItem,
        BottomNavItem.FavoritesItem,
        BottomNavItem.SettingsItem
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val route = backStackEntry?.destination?.route

    BottomNavigation(
         backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
    ) {
        itemList.forEach { item ->
            BottomNavigationItem(
                selected = item.route == route,
                icon = {
                    Icon(painter = painterResource(item.id), contentDescription = null, tint  = MaterialTheme.colorScheme.onSecondaryContainer)
                },
                label = {
                    Text(text = item.title, style = TextStyle(
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    )
                },
                onClick = {
                    navController.navigate(item.route)
                }
            )
        }
    }
}