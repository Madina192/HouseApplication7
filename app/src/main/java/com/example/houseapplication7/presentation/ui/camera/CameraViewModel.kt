package com.example.houseapplication7.presentation.ui.camera

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.data.repositories.CameraRepositoryImpl
import com.example.houseapplication7.domain.models.CameraModel

class CameraViewModel : ViewModel() {

    private val repositoryImpl = CameraRepositoryImpl()

    fun getCameras(): LiveData<List<Camera>> {
        return repositoryImpl.getResult()
    }
}