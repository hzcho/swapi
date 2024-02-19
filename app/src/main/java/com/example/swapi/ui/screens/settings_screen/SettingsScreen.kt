package com.example.swapi.ui.screens.settings_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel()
) {
    val user by viewModel.user.collectAsState()
    val isDarkMode by viewModel.darkMode.collectAsState(initial = false)

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        UserItem(user)
        Spacer(modifier = Modifier.padding(top = 4.dp).fillMaxWidth().height(1.dp).background(Color.LightGray))
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "dark mode",
                style = TextStyle(
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                modifier = Modifier.weight(1f)
            )

            Switch(
                checked =  isDarkMode ?: false,
                onCheckedChange = {change->
                    viewModel.changeMode(change)
                }
            )
        }
    }
}