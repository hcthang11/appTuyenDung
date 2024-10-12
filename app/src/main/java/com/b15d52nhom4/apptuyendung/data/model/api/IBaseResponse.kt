package com.b15d52nhom4.apptuyendung.data.model.api

interface IBaseResponse {
    fun getErrorCode(): Int
    fun getMsg(): String?
    fun getStatus():Int
}