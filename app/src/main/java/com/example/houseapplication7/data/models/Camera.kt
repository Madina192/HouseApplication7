package com.example.houseapplication7.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "camera")
data class Camera(
    @PrimaryKey
    val id: Int,
    val name: String = "Camera",
    @SerializedName("snapshot")
    val image: String ?= null,
    var isFavourite : Boolean = false
) : java.io.Serializable

