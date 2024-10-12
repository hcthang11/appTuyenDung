package com.b15d52nhom4.apptuyendung.data.remote

import com.b15d52nhom4.apptuyendung.data.model.UserExample
import com.b15d52nhom4.apptuyendung.data.model.api.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET
//******************************
//******************************
//***** Create by cuongpq  *****
//******************************
//******************************

interface ApiUser {
    @GET("/api/users")
    fun getUsers(
    ): Observable<UserResponse<MutableList<UserExample>>>
}