package com.example.houseapplication7.domain.repositories

import androidx.lifecycle.MutableLiveData
import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.data.models.Door
import com.example.houseapplication7.domain.models.DoorModel
import com.example.houseapplication7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun getAllDoors(): Flow<Resource<List<DoorModel>>>

    suspend fun getResult() : Flow<List<DoorModel>>

    suspend fun insertDoor(door: DoorModel): Unit

    suspend fun updateDoor(door: DoorModel): Unit

    suspend fun deleteDoor(door: DoorModel): Unit
}