package com.example.houseapplication7.data.remote

import retrofit2.http.GET

interface ApiService {
    @GET("/cameras")
    fun getCameras() {
        //todo
    }
}