package com.example.houseapplication7.presentation.ui.door

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.houseapplication7.domain.models.DoorModel
import com.example.houseapplication7.domain.usecases.GetAllDoorsUseCase
import com.example.houseapplication7.domain.utils.Resource
import com.example.houseapplication7.presentation.utils.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorViewModel @Inject constructor(private val getAllDoorsUseCase: GetAllDoorsUseCase) :
    ViewModel() {

    var _doorsList: MutableStateFlow<UIState<List<DoorModel>>> = MutableStateFlow(UIState.Loading())
    private val doorsList: StateFlow<UIState<List<DoorModel>>> = _doorsList

    fun getAllDoors() {
        viewModelScope.launch {
            getAllDoorsUseCase.getAllDoors().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _doorsList.value = UIState.Loading()
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _doorsList.value = UIState.Success(data = resource.data)
                        } else {
                            _doorsList.value = UIState.Empty()
                        }
                    }
                    is Resource.Error -> _doorsList.value =
                        UIState.Error(message = resource.message ?: "Error")
                }
            }
        }
    }

    fun getResult(){
        viewModelScope.launch {
            getAllDoorsUseCase.getResult().collect{ resource ->
                when(resource) {
                    is Resource.Loading -> _doorsList.value = UIState.Loading()
                    is Resource.Success -> {
                        if (resource.data != null) {
                            _doorsList.value = UIState.Success(data = resource.data)
                            Log.d("ololo", "getResult: ${_doorsList}")
                        } else {
                            _doorsList.value = UIState.Empty()
                        }
                    }

                    is Resource.Error -> _doorsList.value =
                        UIState.Error(message = resource.message ?: "Error")
                }
            }
        }
    }
}