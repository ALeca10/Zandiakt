package com.leca.zandiakt.services

import com.leca.zandiakt.models.Producto
import com.leca.zandiakt.models.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("{id}")
    fun getUserById(@Path("id") id: Long): Call<User>

    @POST("register")
    fun registerUser(@Body user: User): Call<User>

    @GET("/api/productos")
    fun obtenerProductos(): Call<List<Producto>>
}
