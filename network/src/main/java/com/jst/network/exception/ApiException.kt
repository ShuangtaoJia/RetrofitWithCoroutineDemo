package com.jst.network.exception

import java.io.IOException

class ApiException(val errorCode:Int,val errorMsg:String): IOException()