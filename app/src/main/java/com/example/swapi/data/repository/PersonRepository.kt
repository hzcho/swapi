package com.example.swapi.data.repository

import com.example.swapi.data.domain.model.Person
import kotlinx.coroutines.flow.Flow

interface PersonRepository {
    suspend fun getPersonById(id:Int): Person?
    fun getSavedPersons(): Flow<List<Person>>
    suspend fun deletePerson(person: Person)
    suspend fun insertPerson(person: Person)
}