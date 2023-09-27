package com.example.houseapplication7.data.retrofit

import com.example.houseapplication7.data.remote.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    val retrofit = Retrofit.Builder().baseUrl("http://cars.cprogroup.ru/api/rubetek/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    val apiService = retrofit.create(ApiService::class.java)
}