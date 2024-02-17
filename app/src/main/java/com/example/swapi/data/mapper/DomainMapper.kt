package com.example.swapi.data.mapper

interface DomainMapper <NetworkModel, DomainModel> {
    fun mapToDomainModel(model:NetworkModel):DomainModel
    fun mapFromDomainModel(model:DomainModel):NetworkModel
}