package com.weatherapp.usecases.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import com.weatherapp.entities.City

@Dao
interface CitiesDao{

    @Query("select * from City where City.name like :name")
    fun queryCitiesByName(name:String)

    @Query("select * from City where City.id in (:ids)")

    fun queryCitiesById(ids:List<Int>):List<City>
}