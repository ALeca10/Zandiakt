package com.leca.zandiakt.services

import com.leca.zandiakt.models.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/users/{id}")
    fun getUserById(@Path("id") id: Long): Call<User>
}
