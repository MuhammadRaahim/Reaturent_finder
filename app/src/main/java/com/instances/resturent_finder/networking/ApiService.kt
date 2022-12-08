package com.instances.resturent_finder.networking

import com.instances.resturent_finder.networking.request.LoginRequest
import com.instances.resturent_finder.networking.request.UpdateProfileRequest
import com.instances.resturent_finder.networking.response.LoginResponse
import com.instances.resturent_finder.networking.response.UpdateProfileResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface ApiService {

    @POST("user/login")
    fun loginUser(@Body loginRequest: LoginRequest): Call<LoginResponse>

    @PUT("user/{id}")
    fun updateProfile(
        @Path("id") Id: String,
        @Body updateProfileRequest: UpdateProfileRequest
    ): Call<UpdateProfileResponse>
}