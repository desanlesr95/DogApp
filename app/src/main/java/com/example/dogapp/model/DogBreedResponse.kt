package com.example.dogapp.model

import com.google.gson.annotations.SerializedName

data class DogBreedResponse( @SerializedName("message") var message: HashMap<String,List<String>>,@SerializedName("status") var status:String)