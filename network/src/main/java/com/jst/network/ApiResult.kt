package com.jst.network

sealed class ApiResult<out T> {
    data class Success<out T>(val data: T):ApiResult<T>()
    data class Failure(val errorCode:Int,val errorMsg:String):ApiResult<Nothing>()
}