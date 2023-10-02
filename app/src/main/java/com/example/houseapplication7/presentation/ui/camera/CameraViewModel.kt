package com.example.houseapplication7.presentation.ui.camera

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.houseapplication7.data.repositories.CameraRepositoryImpl
import com.example.houseapplication7.domain.models.CameraModel
import com.example.houseapplication7.domain.usecases.GetAllCamerasUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val repositoryImpl: CameraRepositoryImpl) :
    ViewModel() {

    private val camerasUseCase = GetAllCamerasUseCase(repositoryImpl)

    val cameraList = MutableLiveData<List<CameraModel>>()
    fun getCameras(): MutableLiveData<List<CameraModel>> {
        viewModelScope.launch {
            camerasUseCase.getResult()
                .catch { e ->
                    Log.e("ololo", "getCameras: ${e.message}")
                }
                .collect { response ->
                    cameraList.value = response
                    Log.d("ololo", "getCameras: ${response}")
                }
        }
        return cameraList
    }
}