package com.weatherapp.domain.usecases

import android.arch.lifecycle.MutableLiveData
import com.weatherapp.domain.repositories.CitiesRepository
import com.weatherapp.domain.repositories.citiesRepository
import com.weatherapp.entities.City

class SearchCitiesByIdsUseCase(
    private val resultLiveData: MutableLiveData<List<City>>,
    private val searching: MutableLiveData<Boolean>,
    private val repository: CitiesRepository = citiesRepository
) {

    operator fun invoke(citiesIds: List<Long>) {
        citiesIds.takeUnless { searching.value ?: false }
            ?.also { searching.postValue(true) }
            ?.let { repository.retrieveCitiesByIds(it) }
            ?.also { resultLiveData.postValue(it) }
            ?.also { searching.postValue(false) }
    }


}