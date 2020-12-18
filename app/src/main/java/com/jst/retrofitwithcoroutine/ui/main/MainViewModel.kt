package com.jst.retrofitwithcoroutine.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jst.network.ApiResult
import com.jst.retrofitwithcoroutine.ui.main.api.TranslateApi
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _translateSuccessResult: MutableLiveData<String> = MutableLiveData()
    private val _translateFailedResult: MutableLiveData<String> = MutableLiveData()

    val translateSuccessResult: LiveData<String>
        get() = _translateSuccessResult

    val translateFailedResult: LiveData<String>
        get() = _translateFailedResult

    fun translateSuccess(word: String) {
        viewModelScope.launch {
            when (val result = TranslateApi.retrofitService.translate(word)) {
                is ApiResult.Success -> {
                    _translateSuccessResult.value = result.data.translateResult[0][0].tgt
                }
                is ApiResult.Failure -> {
                    _translateSuccessResult.value = "errorCode: ${result.errorCode} errorMsg: ${result.errorMsg}"
                }
            }
        }
    }


    fun translateFailed(word: String) {
        viewModelScope.launch {
            when (val result = TranslateApi.retrofitService.translate(word)) {
                is ApiResult.Success -> {
                    _translateFailedResult.value = result.data.translateResult[0][0].tgt
                }
                is ApiResult.Failure -> {
                    _translateFailedResult.value = "errorCode: ${result.errorCode} errorMsg: ${result.errorMsg}"
                }
            }
        }
    }

}