package com.example.houseapplication7.data.remote

import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.data.models.Door
import com.example.houseapplication7.domain.models.CameraModel
import com.example.houseapplication7.domain.models.DoorModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("cameras")
    fun getCameras() : Call<List<Camera>>

    @GET("/doors")
    fun getDoors() : Call<DoorModel>
}