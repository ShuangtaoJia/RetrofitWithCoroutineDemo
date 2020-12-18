package com.jst.network

/**
 * 客户端本地定义的网络请求的 errorCode 和 errorMsg
 *
 * 这里的errorCode < 0，为了与服务器返回的errorCode做区分，服务器返回的 errorCode > 0
 */
object ApiError {
    //数据是null
    val dataIsNull = Error(-1,"data is null")
    //http status code 不是 成功
    val httpStatusCodeError = Error(-2,"Server error. Please try again later.")
    //未知异常
    val unknownException = Error(-3,"unknown exception")
}

data class Error(val errorCode:Int,val errorMsg:String)