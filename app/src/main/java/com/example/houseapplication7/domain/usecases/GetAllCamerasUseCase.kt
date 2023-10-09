package com.example.houseapplication7.domain.usecases

import com.example.houseapplication7.data.repositories.CameraRepositoryImpl
import javax.inject.Inject

class GetAllCamerasUseCase @Inject constructor(
    private val repository : CameraRepositoryImpl
){
    suspend fun getAllCameras() = repository.getAllCameras()
}