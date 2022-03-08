package com.aevumdev.carrest.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.aevumdev.carrest.models.Car
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class CarsRepository {
    private val url = "https://anbo-restcarswithmanager.azurewebsites.net/api/"
    private val carStoreService : CarStoreService
    val carsLiveData: MutableLiveData<List<Car>> = MutableLiveData<List<Car>>()
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    init{
        val build:Retrofit = Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create()).build()
        carStoreService = build.create(CarStoreService::class.java)
        getCars()
    }

    fun getCars(){
        carStoreService.getAllCars().enqueue(object : Callback<List<Car>> {
            override fun onResponse(call: Call<List<Car>>, response: Response<List<Car>>) {
                if (response.isSuccessful){
                    /*Log.d("REX", response.body().toString())*/
                    carsLiveData.postValue(response.body())
                    errorMessageLiveData.postValue("")
                }
                else{
                    val msg = response.code().toString() + " " + response.message()
                    errorMessageLiveData.postValue(msg)
                    Log.d("REX", msg)
                }
            }

            override fun onFailure(call: Call<List<Car>>, t: Throwable) {
                errorMessageLiveData.postValue(t.message)
                Log.d("REX", t.message!!)
            }

        })
    }
}