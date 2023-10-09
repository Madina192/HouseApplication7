package com.example.houseapplication7.domain.repositories

import com.example.houseapplication7.domain.models.CameraModel
import com.example.houseapplication7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CameraRepository {

    suspend fun getAllCameras(): Flow<Resource<List<CameraModel>>>

    suspend fun getResult() : Flow<List<CameraModel>>

    suspend fun insertCamera(cameras: List<CameraModel>): Unit

    suspend fun updateCamera(camera: CameraModel): Unit

    suspend fun deleteCamera(camera: CameraModel): Unit
}