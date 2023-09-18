package com.example.dogapp.model

import com.google.gson.annotations.SerializedName


class RandomImage(  @SerializedName("message")
                    val message:String,@SerializedName("status") val status:String)