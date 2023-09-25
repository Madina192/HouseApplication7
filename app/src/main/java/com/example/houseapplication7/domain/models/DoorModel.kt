package com.example.houseapplication7.domain.models

data class DoorModel(
    val id: Int,
    val name: String = "Door",
    val image: String ?= null,
    var isFavourite : Boolean = false
)