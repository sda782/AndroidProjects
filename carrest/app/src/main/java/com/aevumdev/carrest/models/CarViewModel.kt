package com.aevumdev.carrest.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.aevumdev.carrest.repository.CarsRepository

class CarViewModel : ViewModel() {
    private val repository = CarsRepository()
    val carsLiveData : LiveData<List<Car>> = repository.carsLiveData
    val errorMessageLiveData: LiveData<String> = repository.errorMessageLiveData

    init {
        reload()
    }
    fun reload(){
        repository.getCars()
    }
}