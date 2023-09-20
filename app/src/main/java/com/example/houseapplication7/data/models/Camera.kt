package com.example.houseapplication7.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "camera")
data class Camera(
    @PrimaryKey
    val id: Int,
    val name: String = "Camera",
    val image: String ?= null,
    var isFavourite : Boolean = false
)
