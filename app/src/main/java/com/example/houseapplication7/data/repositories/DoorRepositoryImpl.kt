package com.example.houseapplication7.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.houseapplication7.data.db.dao.DoorDao
import com.example.houseapplication7.data.models.Door
import com.example.houseapplication7.domain.models.DoorModel
import com.example.houseapplication7.domain.repositories.DoorRepository
import com.example.houseapplication7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DoorRepositoryImpl @Inject constructor(
    private val doorDao: DoorDao
) : DoorRepository {

    override suspend fun getAllDoors(): Flow<Resource<List<DoorModel>>> {
        TODO("Not yet implemented")
    }

    override fun getResult(): MutableLiveData<List<Door>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updateDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDoor(door: DoorModel) {
        TODO("Not yet implemented")
    }
}