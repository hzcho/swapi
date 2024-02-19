package com.example.swapi.ui.screens.favorites

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun FavoritesScreen(
    viewModel: FavoritesViewModel = hiltViewModel()
) {
    val favorites = viewModel.favorites.collectAsState(emptyList())

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(favorites.value) { person ->
            FavoritePersonItem(
                person,
                onFavoriteChange = {person->
                    viewModel.updatePerson(person)
                },
                onClick = {

                },
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}