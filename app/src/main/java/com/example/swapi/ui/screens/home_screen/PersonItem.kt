package com.example.swapi.ui.screens.home_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.swapi.data.domain.model.Person

@Composable
fun PersonItem(
    person: Person,
    modifier: Modifier = Modifier,
    onFavoriteChange: (Person) -> Unit,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier.clickable {
            onClick()
        },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth().padding(4.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = "person icon",
                modifier = Modifier.size(64.dp).padding(start = 4.dp, end = 4.dp)
            )

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = person.name,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = person.birth_year,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Light
                    )
                )
            }

            IconButton(onClick = { onFavoriteChange(person.copy(isFavorite = !person.isFavorite)) }) {
                Icon(
                    imageVector = Icons.Default.Favorite,
                    contentDescription = "add to favorites",
                    modifier = Modifier.padding(end = 12.dp),
                    tint = if (person.isFavorite) Color.Red else MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
        }
    }
}