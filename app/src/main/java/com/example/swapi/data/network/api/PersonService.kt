package com.example.swapi.data.network.api

import com.example.swapi.data.network.model.PersonModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PersonService{
    @GET("people/{id}")
    suspend fun getPersonById(@Path("id") id:Int): Response<PersonModel>
}