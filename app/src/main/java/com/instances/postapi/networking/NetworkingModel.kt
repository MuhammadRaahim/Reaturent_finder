package com.instances.postapi.networking

import com.instances.postapi.networking.request.LoginRequest
import com.instances.postapi.networking.response.LoginResponse


class NetworkingModel : NetworkingHelper() {

    fun excLoginUserApi(
        loginRequest: LoginRequest,
        apiListener: ApiListener<LoginResponse>
    ) {
        loginUser(loginRequest, apiListener = apiListener)
    }

}