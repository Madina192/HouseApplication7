package com.example.houseapplication7.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.data.models.Door

@Database(entities = [Camera::class, Door::class], version = 1, exportSchema = true)
abstract class HouseDatabase : RoomDatabase(){
    //todo
}