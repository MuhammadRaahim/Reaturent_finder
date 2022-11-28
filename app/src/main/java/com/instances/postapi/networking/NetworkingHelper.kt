package com.instances.postapi.networking

import com.instances.postapi.networking.RetrofitClient.getApiEndpointImpl
import com.instances.postapi.networking.request.LoginRequest
import com.instances.postapi.networking.response.LoginResponse

// this class help to call get the retrofit instance in networking model class where api is calling
abstract class NetworkingHelper {

    private val apiService = getApiEndpointImpl()

    fun loginUser(loginRequest: LoginRequest, apiListener: ApiListener<LoginResponse>) {
        val call = apiService.loginUser(loginRequest)
        RetrofitClient.executeApi(call, apiListener)
    }

}
