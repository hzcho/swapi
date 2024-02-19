package com.example.swapi.ui.screens.favorites

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swapi.data.domain.model.Person
import com.example.swapi.data.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritesViewModel @Inject constructor(
    private val repository: PersonRepository
):ViewModel() {
    val favorites=repository.getSavedFavorites()

    fun updatePerson(person:Person){
        viewModelScope.launch {
            repository.updatePerson(person)
        }
    }
}