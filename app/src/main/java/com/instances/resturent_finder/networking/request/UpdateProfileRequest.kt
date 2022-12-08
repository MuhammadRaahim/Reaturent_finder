package com.instances.resturent_finder.networking.request

import com.google.gson.annotations.SerializedName

data class UpdateProfileRequest (
    @SerializedName("id_member"       ) var idMember       : String? = null,
    @SerializedName("NIK"             ) var NIK            : String? = null,
    @SerializedName("email"           ) var email          : String? = null,
    @SerializedName("password"        ) var password       : String? = null,
    @SerializedName("name"            ) var name           : String? = null,
    @SerializedName("address"         ) var address        : String? = null,
    @SerializedName("phone"           ) var phone          : String? = null,
    @SerializedName("birthdate"       ) var birthdate      : String? = null,
    @SerializedName("birthplace"      ) var birthplace     : String? = null,
    @SerializedName("gender"          ) var gender         : String? = null,
    @SerializedName("role"            ) var role           : String? = null,
    @SerializedName("balance"         ) var balance        : Int?    = null,
    @SerializedName("profile_picture" ) var profilePicture : String? = null
        )