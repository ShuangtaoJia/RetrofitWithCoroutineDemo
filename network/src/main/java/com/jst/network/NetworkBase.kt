package com.jst.network

import com.jst.network.calladapter.ApiResultCallAdapterFactory
import com.jst.network.interceptor.BusinessErrorInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "http://fanyi.youdao.com/"

private val okHttpClient = OkHttpClient.Builder()
    .addInterceptor(BusinessErrorInterceptor())
    .build()

val retrofit = Retrofit.Builder()
    .addCallAdapterFactory(ApiResultCallAdapterFactory())
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .client(okHttpClient)
    .build()