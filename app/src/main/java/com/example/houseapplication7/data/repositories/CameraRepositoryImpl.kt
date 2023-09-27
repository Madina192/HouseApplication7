package com.example.houseapplication7.data.repositories

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.data.retrofit.RetrofitService
import com.example.houseapplication7.domain.models.CameraModel
import com.example.houseapplication7.domain.repositories.CameraRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CameraRepositoryImpl : CameraRepository {

    override suspend fun getAllCameras(): List<CameraModel> {
        TODO("Not yet implemented")
    }

    override fun getResult(): MutableLiveData<List<Camera>> {
        //val listOfCameras = ArrayList<Camera>()
        val liveData = MutableLiveData<List<Camera>>()
        RetrofitService.apiService.getCameras().enqueue(object : Callback<List<Camera>> {
            override fun onResponse(
                call: Call<List<Camera>>,
                response: Response<List<Camera>>
            ) {
                //listOfCameras.add(response.body())
                liveData.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Camera>>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
        return liveData
    }

    override suspend fun insertCamera(camera: CameraModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCamera(camera: CameraModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCamera(camera: CameraModel) {
        TODO("Not yet implemented")
    }
}