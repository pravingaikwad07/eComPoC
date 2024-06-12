package com.praving.bareztechecom.poc.data.network

sealed class Result<out T> {

    data class Success<out T>(val data: T) : Result<T>()
    data class Failure(val msg: Throwable?) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success $data"
            is Failure -> "Failure $msg"
            Loading -> "Loading"
        }
    }
}