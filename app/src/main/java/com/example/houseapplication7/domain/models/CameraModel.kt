package com.example.houseapplication7.domain.models

data class CameraModel(
    val id: Int,
    val name: String = "Camera",
    val image: String ?= null,
    var isFavourite : Boolean = false
)
