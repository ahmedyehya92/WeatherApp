package com.waether.app.features.randomizer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.weatherapp.usecases.Ticker
import com.weatherapp.usecases.numberIncrementer
import com.weatherapp.usecases.randomNumberGenerator


 const val DEFAULT_VALUE = 0

class RandomizerViewModel : ViewModel() {


    val numberLiveData = MutableLiveData<Int>()



    init {
        numberLiveData.value = DEFAULT_VALUE

    }


    fun incrementNumber(){
        numberIncrementer( numberLiveData)

    }



    override fun onCleared() {
        super.onCleared()
    }

}