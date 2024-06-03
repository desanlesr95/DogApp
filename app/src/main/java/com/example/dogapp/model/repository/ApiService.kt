package com.example.dogapp.model.repository

import com.example.dogapp.model.BreedImageRandom
import com.example.dogapp.model.DogBreedResponse
import com.example.dogapp.model.LoginResponse
import com.example.dogapp.model.RandomImage
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("api/breeds/image/random")
    fun getRandomImage(): Call<RandomImage>


    @GET("api/breeds/list/all")
    fun getBreedList(): Call<DogBreedResponse>



    @GET("api/breed/hound/images/random/3")
    fun getRandomImagesByBreed():Call<BreedImageRandom>



    @FormUrlEncoded
    @POST("api/users/login/")
    fun getLogin(@Field("mail") username:String,@Field("password") passowrd:String):Call<LoginResponse>



}