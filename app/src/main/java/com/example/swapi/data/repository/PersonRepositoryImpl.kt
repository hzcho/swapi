package com.example.swapi.data.repository

import com.example.swapi.data.domain.dao.PersonDao
import com.example.swapi.data.domain.model.Person
import com.example.swapi.data.mapper.PersonMapper
import com.example.swapi.data.network.api.PersonService
import com.example.swapi.data.network.model.PersonModel

class PersonRepositoryImpl(
    private val dao: PersonDao,
    private val service: PersonService
) : PersonRepository {
    val mapper = PersonMapper()

    override suspend fun getPersonById(id: Int): Person? {
        val response = service.getPersonById(id)
        val result=if (response.body() == null || response.body() !is PersonModel){
            null
        }else{
            mapper.mapToDomainModel(response.body()!!)
        }

        return result
    }

    override fun getSavedPersons() = dao.getAllPersons()
    override fun getSavedFavorites() = dao.getFavorites()
    override suspend fun deletePerson(person: Person) = dao.deletePerson(person)
    override suspend fun insertPerson(person: Person) = dao.insertPerson(person)
    override suspend fun updatePerson(person: Person) = dao.updatePerson(person)
}