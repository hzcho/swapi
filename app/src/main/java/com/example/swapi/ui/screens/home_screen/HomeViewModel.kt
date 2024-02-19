package com.example.swapi.ui.screens.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.swapi.data.domain.model.Person
import com.example.swapi.data.repository.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: PersonRepository
) : ViewModel() {
    val persons = repository.getSavedPersons()
    private var person: Person? = null

    private val _editableText = MutableStateFlow("")
    val editableText = _editableText.asStateFlow()

    fun getPersonById() {
        if (_editableText.value.isNotEmpty()) {
            viewModelScope.launch {
                person = repository.getPersonById(_editableText.value.toInt())
                person?.let { repository.insertPerson(it) }
            }
        }
    }

    fun onTextChange(text: String) {
        _editableText.value = text
    }

    fun updatePerson(person: Person){
        viewModelScope.launch {
            repository.updatePerson(person)
        }
    }
}