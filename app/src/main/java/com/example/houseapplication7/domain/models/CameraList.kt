package com.example.houseapplication7.domain.models

import com.example.houseapplication7.data.models.Camera

data class CameraList(
    var data: Data
)

data class Data(
    var cameras: List<Camera>
)

