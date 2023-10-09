package com.example.houseapplication7.data.repositories

import com.example.houseapplication7.data.db.dao.CameraDao
import com.example.houseapplication7.data.retrofit.RetrofitService
import com.example.houseapplication7.data.utils.convertToCamera
import com.example.houseapplication7.data.utils.mapToCameraList
import com.example.houseapplication7.data.utils.mapToCameraModel
import com.example.houseapplication7.domain.models.CameraModel
import com.example.houseapplication7.domain.repositories.CameraRepository
import com.example.houseapplication7.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(
    private val cameraDao: CameraDao
) : CameraRepository {

    override suspend fun getAllCameras(): Flow<Resource<List<CameraModel>>> {
        return flow {
            emit(Resource.Loading())
            try {
                val data = cameraDao.getAllCameras().mapToCameraModel()
                emit(Resource.Success(data))
            } catch (e: Exception) {
                emit(Resource.Error(e.message ?: "Message is empty"))
            }
        }
    }

    override suspend fun getResult(): Flow<List<CameraModel>> {
        return flow {
            var data = RetrofitService.apiService.getCameras().body()?.data?.cameras
            if (data != null) {
                emit(data)
                cameraDao.insertCamera(data.mapToCameraList())
            }
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun insertCamera(cameras: List<CameraModel>) {
        TODO()
    }

    override suspend fun updateCamera(camera: CameraModel) {
        cameraDao.updateCamera(camera.convertToCamera())
    }

    override suspend fun deleteCamera(camera: CameraModel) {
        cameraDao.deleteCamera(camera.convertToCamera())
    }
}