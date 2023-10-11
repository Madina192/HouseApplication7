package com.example.houseapplication7.domain.repositories

import com.example.houseapplication7.domain.models.DoorModel
import com.example.houseapplication7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun getAllDoors(): Flow<Resource<List<DoorModel>>>

    suspend fun getResult() : Flow<Resource<List<DoorModel>>>

    suspend fun insertDoor(doors: List<DoorModel>): Unit

    suspend fun updateDoor(door: DoorModel): Unit

    suspend fun deleteDoor(door: DoorModel): Unit
}