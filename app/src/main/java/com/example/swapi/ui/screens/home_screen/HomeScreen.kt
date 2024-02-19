package com.example.swapi.ui.screens.home_screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val persons by viewModel.persons.collectAsState(initial = emptyList())


    Column(modifier = Modifier.fillMaxSize()) {
        SearchTextField(
            viewModel = viewModel,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .clip(RoundedCornerShape(24.dp))
        )

        LazyColumn(
            contentPadding = PaddingValues(bottom = 200.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(persons) { person ->
                PersonItem(
                    person = person,
                    modifier = Modifier.padding(4.dp),
                    onFavoriteChange = {person->
                        viewModel.updatePerson(person)
                    },
                    onClick = {}
                )
            }
        }
    }
}