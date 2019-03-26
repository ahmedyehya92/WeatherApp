package com.weatherapp.domain.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import com.weatherapp.entities.City
import com.weatherapp.entities.FavoriteCityId
import com.weatherapp.domain.applicationLiveData
import com.weatherapp.domain.getApplication


val weatherDatabase by lazy {
    initializeDatabase(applicationLiveData.getApplication())
}

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