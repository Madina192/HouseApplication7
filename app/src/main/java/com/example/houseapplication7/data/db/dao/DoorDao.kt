package com.example.houseapplication7.data.db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.houseapplication7.data.models.Door

@Dao
interface DoorDao {
    @Query("SELECT * FROM door")
    suspend fun getAllDoors() : List<Door>

    @Insert
    suspend fun insertDoor(doors : List<Door>) : Unit

    @Update
    suspend fun updateDoor(door: Door) : Unit

    @Delete
    suspend fun deleteDoor(door: Door) : Unit
}