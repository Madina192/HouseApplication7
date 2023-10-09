package com.example.houseapplication7.data.utils

import com.example.houseapplication7.data.models.Camera
import com.example.houseapplication7.data.models.Door
import com.example.houseapplication7.domain.models.CameraModel
import com.example.houseapplication7.domain.models.DoorModel

fun List<Camera>.mapToCameraModel() = this.map { camera ->
    CameraModel(
        id = camera.id,
        name = camera.name,
        image = camera.image,
        isFavourite = camera.isFavourite
    )
}

fun List<CameraModel>.mapToCameraList() = this.map { camera ->
    Camera(
        id = camera.id,
        name = camera.name,
        image = camera.image,
        isFavourite = camera.isFavourite
    )
}

fun List<Door>.mapToDoorModel() = this.map { door ->
    DoorModel(
        id = door.id,
        name = door.name,
        isFavourite = door.isFavourite
    )
}

fun List<DoorModel>.mapToDoorList() = this.map { door ->
    Door(
        id = door.id,
        name = door.name,
        isFavourite = door.isFavourite
    )
}

fun CameraModel.convertToCamera() =
    Camera(
        id = this.id,
        name = this.name,
        image = this.image,
        isFavourite = this.isFavourite
    )

fun DoorModel.convertToDoor() =
    Door(
        id = this.id,
        name = this.name,
        isFavourite = this.isFavourite
    )