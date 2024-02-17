package com.example.swapi.data.domain.converter

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converter {
    @TypeConverter
    fun listToString(list:List<String>):String{
        val gson=Gson()
        val result=gson.toJson(list)

        return result
    }

    @TypeConverter
    fun stringToList(json:String):List<String>{
        val gson=Gson()
        val type: Type = object : TypeToken<List<String>>() {}.type
        val result=gson.fromJson<List<String>>(json, type)
        return result
    }
}