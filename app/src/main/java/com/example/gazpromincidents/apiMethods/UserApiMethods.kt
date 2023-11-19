package com.example.gazpromincidents.apiMethods

import com.example.gazpromincidents.models.User
import com.example.gazpromincidents.models.UserLogin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface UserApiMethods {
    @POST("/api/v1/user/login")
    suspend fun loginUser(@Body user: UserLogin): Response<User>
}