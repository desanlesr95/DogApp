package com.example.dogapp.model

import com.example.dogapp.model.entitiy.User
import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message") val message:String,
    @SerializedName("user") val user: User,
    @SerializedName("token") val token:String)
