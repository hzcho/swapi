package com.example.swapi.data.domain.dao

import androidx.room.*
import com.example.swapi.data.domain.model.Person
import kotlinx.coroutines.flow.Flow
import retrofit2.http.DELETE

@Dao
interface PersonDao{
    @Query("SELECT * FROM person WHERE id=:id")
    suspend fun getPersonById(id:Int): Person

    @Query("SELECT * FROM person")
    fun getAllPersons(): Flow<List<Person>>

    @Insert
    suspend fun insertPerson(person: Person)

    @Update
    suspend fun updatePerson(person: Person)

    @Delete
    suspend fun deletePerson(person:Person)
}