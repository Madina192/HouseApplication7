package com.example.houseapplication7.data.remote

import com.example.houseapplication7.domain.models.CameraList
import com.example.houseapplication7.domain.models.DoorModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("cameras")
    fun getCameras() : Call<CameraList>

    @GET("/doors")
    fun getDoors() : Call<DoorModel>
}