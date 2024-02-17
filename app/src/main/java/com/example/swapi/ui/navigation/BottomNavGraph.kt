package com.example.swapi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.swapi.ui.screens.home_screen.HomeScreen
import com.example.swapi.ui.util.Routes

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController=navController, startDestination = Routes.HOME_SCREEN){
        composable(
            route = Routes.HOME_SCREEN
        ){
            HomeScreen()
        }
    }
}