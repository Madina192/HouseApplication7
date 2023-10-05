package com.example.houseapplication7.data.remote

import com.example.houseapplication7.domain.models.CameraList
import com.example.houseapplication7.domain.models.DoorList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("cameras")
    suspend fun getCameras(): Response<CameraList>

    @GET("doors")
    suspend fun getDoors(): Response<DoorList>
}