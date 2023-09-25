package com.example.houseapplication7.domain.repositories

import com.example.houseapplication7.domain.models.DoorModel

interface DoorRepository {

    suspend fun getAllDoors(): List<DoorModel>

    suspend fun insertDoor(door: DoorModel): Unit

    suspend fun updateDoor(door: DoorModel): Unit

    suspend fun deleteDoor(door: DoorModel): Unit
}