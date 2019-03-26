package com.waether.app.features.randomizer

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.weatherapp.domain.usecases.numberIncrementer


const val DEFAULT_VALUE = 0

class RandomizerViewModel : ViewModel() {


    val numberLiveData = MutableLiveData<Int>()



    init {
        numberLiveData.value = DEFAULT_VALUE

    }


    fun incrementNumber(){
        numberIncrementer(numberLiveData)

    }



    override fun onCleared() {
        super.onCleared()
    }

}