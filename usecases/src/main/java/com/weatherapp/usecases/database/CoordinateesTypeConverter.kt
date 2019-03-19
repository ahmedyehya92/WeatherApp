package com.weatherapp.usecases.database

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.weatherapp.entities.Coordinates


class CoordinateesTypeConverter {

    @TypeConverter
    fun toJson(coordinates: Coordinates) = Gson().toJson(coordinates)

    @TypeConverter
    fun fromJson(string: String) = Gson().fromJson(string, Coordinates::class.java)

}