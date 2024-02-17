package com.example.swapi.data.domain

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.swapi.data.domain.converter.Converter
import com.example.swapi.data.domain.dao.PersonDao
import com.example.swapi.data.domain.model.Person

@Database(
    entities = [Person::class],
    version = 1
)
@TypeConverters(Converter::class)
abstract class MainDb:RoomDatabase() {
    abstract val personDao: PersonDao
}