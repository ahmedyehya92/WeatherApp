package com.weatherapp.usecases.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import com.weatherapp.entities.City
import com.weatherapp.entities.FavoriteCityId

@Database(entities = [City::class, FavoriteCityId::class]
,
    version = 1,
    exportSchema = true
)

@TypeConverters(CoordinateesTypeConverter::class)
abstract class WeatherDatabase : RoomDatabase(){

    abstract val citiesDao: CitiesDao
    abstract val favoritesDao : FavoritesDao
}