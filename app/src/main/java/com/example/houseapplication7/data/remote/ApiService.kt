package com.example.houseapplication7.data.remote

import com.example.houseapplication7.domain.models.CameraList
import com.example.houseapplication7.domain.models.DoorList
import com.example.houseapplication7.domain.models.DoorModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras")
    suspend fun getCameras(): Response<CameraList>

    @GET("doors")
    fun getDoors(): Response<DoorList>
}