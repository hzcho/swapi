package com.example.swapi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.swapi.data.datastore.DataStoreManager
import com.example.swapi.data.datastore.DsKeys
import com.example.swapi.ui.screens.main_screen.MainScreen
import com.example.swapi.ui.theme.SwapiTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var dataStoreManager: DataStoreManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var isDarkMode by remember{mutableStateOf(true)}
            LaunchedEffect(key1 = isDarkMode){
                dataStoreManager.getBooleanValue(DsKeys.DARK_MODE).collect(){ bool->
                    isDarkMode=bool ?: false
                }
            }
            SwapiTheme(isDarkMode) {
                MainScreen()
            }
        }
    }
}