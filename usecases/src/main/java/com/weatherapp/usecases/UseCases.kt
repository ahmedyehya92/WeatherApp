package com.weatherapp.usecases

import android.arch.lifecycle.MutableLiveData

fun randomNumberGenerator() = Math.random() * 1000

fun numberIncrementer(liveData: MutableLiveData<Int>, incrementBy:Int=1){
    val oldValue =liveData.value?:0
    liveData.postValue(oldValue+incrementBy)
}