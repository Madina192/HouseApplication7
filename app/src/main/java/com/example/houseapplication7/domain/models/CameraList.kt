package com.example.houseapplication7.domain.models

data class CameraList(
    var data: CameraData
)

data class CameraData(
    var cameras: List<CameraModel>
)

