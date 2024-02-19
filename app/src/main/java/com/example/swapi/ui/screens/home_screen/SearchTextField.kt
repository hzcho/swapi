package com.example.swapi.ui.screens.home_screen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.swapi.ui.theme.OnPrimaryContainer
import com.example.swapi.ui.theme.PrimaryContainer

@Composable
fun SearchTextField(
    viewModel: HomeViewModel,
    modifier:Modifier=Modifier
) {
    val editableText by viewModel.editableText.collectAsState()
    Card(
        colors = CardDefaults.cardColors(
            contentColor = MaterialTheme.colorScheme.onSecondaryContainer,
            containerColor = MaterialTheme.colorScheme.secondaryContainer
        ),
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(start = 4.dp, end = 4.dp)
        ) {
            TextField(
                value = editableText,
                textStyle = TextStyle(
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                ),
                label = {
                        Text(text = "search...", style = TextStyle(
                            color = MaterialTheme.colorScheme.onSecondaryContainer,
                            fontFamily = FontFamily.SansSerif
                        )
                        )
                },
                onValueChange = { newText ->
                    viewModel.onTextChange(newText)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number
                ),
                colors = TextFieldDefaults.colors(
                    unfocusedIndicatorColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    focusedContainerColor = Color.Transparent
                ),
                modifier = Modifier.weight(1f)
            )

            IconButton(
                onClick = { viewModel.getPersonById() }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "add"
                )
            }
        }
    }
}