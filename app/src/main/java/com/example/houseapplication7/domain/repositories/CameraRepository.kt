package com.example.houseapplication7.domain.repositories

import androidx.lifecycle.MutableLiveData
import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.domain.models.CameraList
import com.example.houseapplication7.domain.models.CameraModel

interface CameraRepository {

    suspend fun getAllCameras(): List<CameraModel>

    fun getResult() : MutableLiveData<List<Camera>>

    suspend fun insertCamera(camera: CameraModel): Unit

    suspend fun updateCamera(camera: CameraModel): Unit

    suspend fun deleteCamera(camera: CameraModel): Unit
}