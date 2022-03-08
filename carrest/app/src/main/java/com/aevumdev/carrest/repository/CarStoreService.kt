package com.aevumdev.carrest.repository

import com.aevumdev.carrest.models.Car
import retrofit2.Call
import retrofit2.http.*

interface CarStoreService {
    @GET("cars")
    fun getAllCars(): Call<List<Car>>
}