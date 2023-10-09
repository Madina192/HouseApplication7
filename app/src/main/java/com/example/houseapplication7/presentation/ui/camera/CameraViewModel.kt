package com.example.houseapplication7.presentation.ui.camera

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.houseapplication7.domain.models.CameraModel
import com.example.houseapplication7.domain.usecases.GetAllCamerasUseCase
import com.example.houseapplication7.domain.utils.Resource
import com.example.houseapplication7.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CameraViewModel @Inject constructor(private val getAllCamerasUseCase: GetAllCamerasUseCase) :
    ViewModel() {

    var _cameraList: MutableStateFlow<UIState<List<CameraModel>>> =
        MutableStateFlow(UIState.Loading())
    private val camerasList: StateFlow<UIState<List<CameraModel>>> = _cameraList

    fun getAllCameras() {
        viewModelScope.launch {
            getAllCamerasUseCase.getAllCameras().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _cameraList.value = UIState.Loading()
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _cameraList.value = UIState.Success(data = resource.data)
                            Log.d("ololo", "getAllCameras: ${_cameraList}")
                        } else {
                            _cameraList.value = UIState.Empty()
                        }
                    }

                    is Resource.Error -> _cameraList.value =
                        UIState.Error(message = resource.message ?: "Error")
                }
            }
        }
    }
}