package com.example.swapi.ui.screens.main_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(){
    val navController= rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNav(navController){

            }
        }
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Button(onClick = {}){
                Text(text = "color")
            }
        }
    }
}