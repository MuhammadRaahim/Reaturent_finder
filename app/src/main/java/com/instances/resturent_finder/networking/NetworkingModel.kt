package com.instances.resturent_finder.networking

import com.instances.resturent_finder.networking.request.LoginRequest
import com.instances.resturent_finder.networking.request.UpdateProfileRequest
import com.instances.resturent_finder.networking.response.LoginResponse
import com.instances.resturent_finder.networking.response.UpdateProfileResponse


class NetworkingModel : NetworkingHelper() {

    fun excLoginUserApi(
        loginRequest: LoginRequest,
        apiListener: ApiListener<LoginResponse>
    ) {
        loginUser(loginRequest, apiListener = apiListener)
    }

    fun excUpdateUserApi(
        id: String,
        request:UpdateProfileRequest,
        apiListener: ApiListener<UpdateProfileResponse>)
    {
        updateProfile(id,request, apiListener = apiListener)
    }

}