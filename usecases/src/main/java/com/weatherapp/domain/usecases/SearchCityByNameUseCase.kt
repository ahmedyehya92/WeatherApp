package com.weatherapp.domain.usecases

import android.arch.lifecycle.MutableLiveData
import com.weatherapp.domain.repositories.CitiesRepository
import com.weatherapp.domain.repositories.citiesRepository
import com.weatherapp.entities.City

typealias CitiesResult = MutableLiveData<List<City>>

class SearchCityByNameUseCase(
    private val searching: MutableLiveData<Boolean>,
    private val result: CitiesResult,
    private val repository: CitiesRepository = citiesRepository
) {
    operator fun invoke(cityName: String?) {
        cityName
            ?.takeUnless { searching.value ?: false }
            ?.takeUnless { it.isBlank() }
            ?.also { searching.postValue(true) }
            ?.let { repository.searchCitiesByName(it) }
            ?.also { result.postValue(it) }
            ?.also { searching.postValue(false) }
    }

}