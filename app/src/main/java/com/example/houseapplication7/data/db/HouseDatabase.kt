package com.example.houseapplication7.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.houseapplication7.data.db.dao.CameraDao
import com.example.houseapplication7.data.db.dao.DoorDao
import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.data.models.Door

@Database(entities = [Camera::class, Door::class], version = 1, exportSchema = true)
abstract class HouseDatabase : RoomDatabase(){
    abstract fun getCameraDao() : CameraDao
    abstract fun getDoorDao() : DoorDao
}