package com.example.houseapplication7.domain.usecases

import com.example.houseapplication7.data.repositories.DoorRepositoryImpl
import javax.inject.Inject

class GetAllDoorsUseCase @Inject constructor(
    private val repository : DoorRepositoryImpl
){
    suspend fun getAllDoors() = repository.getAllDoors()
}