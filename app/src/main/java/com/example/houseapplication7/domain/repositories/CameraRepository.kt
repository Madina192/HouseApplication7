package com.example.houseapplication7.domain.repositories

import com.example.houseapplication7.domain.models.CameraModel

interface CameraRepository {

    suspend fun getAllCameras(): List<CameraModel>

    suspend fun insertCamera(camera: CameraModel): Unit

    suspend fun updateCamera(camera: CameraModel): Unit

    suspend fun deleteCamera(camera: CameraModel): Unit
}