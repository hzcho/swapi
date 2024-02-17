package com.example.swapi.data.mapper

import com.example.swapi.data.domain.model.Person
import com.example.swapi.data.network.model.PersonModel

class PersonMapper: DomainMapper<PersonModel, Person> {
    override fun mapToDomainModel(model: PersonModel): Person {
        return Person(
            id = null,
        name=model.name,
        height=model.height,
        mass=model.mass,
        hair_color=model.hair_color,
        skin_color=model.skin_color,
        eye_color=model.eye_color,
        birth_year=model.birth_year,
        gender=model.gender,
        homeworld=model.homeworld,
        films=model.films,
        species=model.species,
        vehicles=model.vehicles,
        starships=model.starships,
        created=model.created,
        edited=model.edited,
        url=model.url
        )
    }

    override fun mapFromDomainModel(model: Person): PersonModel {
        return PersonModel(
            name=model.name,
            height=model.height,
            mass=model.mass,
            hair_color=model.hair_color,
            skin_color=model.skin_color,
            eye_color=model.eye_color,
            birth_year=model.birth_year,
            gender=model.gender,
            homeworld=model.homeworld,
            films=model.films,
            species=model.species,
            vehicles=model.vehicles,
            starships=model.starships,
            created=model.created,
            edited=model.edited,
            url=model.url
        )
    }
}