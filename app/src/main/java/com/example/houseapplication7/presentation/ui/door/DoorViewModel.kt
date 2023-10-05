package com.example.houseapplication7.presentation.ui.door

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.houseapplication7.data.repositories.DoorRepositoryImpl
import com.example.houseapplication7.domain.models.DoorModel
import com.example.houseapplication7.domain.usecases.GetAllDoorsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorViewModel @Inject constructor(private val repositoryImpl: DoorRepositoryImpl) :
    ViewModel() {

    private val doorsUseCase = GetAllDoorsUseCase(repositoryImpl)

    val doorList = MutableLiveData<List<DoorModel>>()

    init {
        getDoors()
    }

    fun getDoors() {
        viewModelScope.launch {
            doorsUseCase.getResult().collect { response ->
                doorList.postValue(response)
                Log.d("ololo", "getDoors: ${response}")
            }
        }
    }
}