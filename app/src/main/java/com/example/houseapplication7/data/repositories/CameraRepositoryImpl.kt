package com.example.houseapplication7.data.repositories

import android.content.ContentValues.TAG
import android.util.Log
import com.example.houseapplication7.data.db.dao.CameraDao
import com.example.houseapplication7.data.retrofit.RetrofitService
import com.example.houseapplication7.data.utils.convertToCamera
import com.example.houseapplication7.data.utils.mapToCameraModel
import com.example.houseapplication7.domain.models.CameraList
import com.example.houseapplication7.domain.models.CameraModel
import com.example.houseapplication7.domain.repositories.CameraRepository
import com.example.houseapplication7.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

    override suspend fun getResult(): Flow<List<CameraModel>> = flow<List<CameraModel>> {
        var data = listOf<CameraModel>()
        emit(data)

        RetrofitService.apiService.getCameras().enqueue(object : Callback<CameraList> {

            override fun onResponse(call: Call<CameraList>, response: Response<CameraList>) {
                data = response.body()?.data?.cameras?.mapToCameraModel()!!
            }

            override fun onFailure(call: Call<CameraList>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }
        })

//        try {
//            emit(data)
//        } catch (e: Exception) {
//            emit(Resource.Error(e.message ?: "Message is empty"))
//        }
    }.flowOn(Dispatchers.IO)

    override suspend fun insertCamera(camera: CameraModel) {
        cameraDao.insertCamera(camera.convertToCamera())
    }

    override suspend fun updateCamera(camera: CameraModel) {
        cameraDao.updateCamera(camera.convertToCamera())
    }

    override suspend fun deleteCamera(camera: CameraModel) {
        cameraDao.deleteCamera(camera.convertToCamera())
    }
}