package com.hcthang.apptuyendung.data.remote

import com.hcthang.apptuyendung.data.model.UserExample
import com.hcthang.apptuyendung.data.model.api.UserResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiUser {
    @GET("/api/users")
    fun getUsers(
    ): Observable<UserResponse<MutableList<UserExample>>>
}