package com.example.houseapplication7.data.repositories

import com.example.houseapplication7.data.db.dao.DoorDao
import com.example.houseapplication7.data.retrofit.RetrofitService
import com.example.houseapplication7.data.utils.convertToDoor
import com.example.houseapplication7.data.utils.mapToDoorModel
import com.example.houseapplication7.domain.models.DoorModel
import com.example.houseapplication7.domain.repositories.DoorRepository
import com.example.houseapplication7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class DoorRepositoryImpl @Inject constructor(
    private val doorDao: DoorDao
) : DoorRepository {

    override suspend fun getAllDoors(): Flow<Resource<List<DoorModel>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = doorDao.getAllDoors().mapToDoorModel()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Message is empty"))
            }
        }
    }

    override suspend fun getResult(): Flow<List<DoorModel>> {
        return flow {
            var data = RetrofitService.apiService.getDoors().body()?.data?.doors
            if (data != null) {
                emit(data)
            }
        }
    }

    override suspend fun insertDoor(door: DoorModel) {
        doorDao.insertDoor(door.convertToDoor())
    }

    override suspend fun updateDoor(door: DoorModel) {
        doorDao.updateDoor(door.convertToDoor())
    }

    override suspend fun deleteDoor(door: DoorModel) {
        doorDao.deleteDoor(door.convertToDoor())
    }
}