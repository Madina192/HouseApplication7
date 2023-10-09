package com.example.houseapplication7.presentation.utils

sealed class UIState<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T>() : UIState<T>()
    class Success<T>(data: T?) : UIState<T>()
    class Empty<T> : UIState<T>()
    class Error<T>(message: String?) : UIState<T>()
}