package com.example.graphqlrickmorty.extra

sealed class ViewState<T>(
    val message: String? = null,
    val data: T? = null
) {
    class Success<T>(data: T?) : ViewState<T>(data = data)
    class Error<T>(error: String?, data: T? = null) : ViewState<T>(error, data)
    class Loading<T> : ViewState<T>()
}