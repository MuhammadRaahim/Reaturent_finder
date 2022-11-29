package com.instances.resturent_finder.utils

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Response (
    @SerializedName("key"  ) var key  : String?         = null,
    @SerializedName("data" ) var data : ArrayList<Data> = arrayListOf()

): Serializable

data class Data (
    @SerializedName("name"        ) var name        : String? = null,
    @SerializedName("url"         ) var url         : String? = null,
    @SerializedName("description" ) var description : String? = null,
    @SerializedName("lat"         ) var lat         : String? = null,
    @SerializedName("long"        ) var long        : String? = null
): Serializable