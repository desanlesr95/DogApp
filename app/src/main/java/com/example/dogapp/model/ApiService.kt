package com.example.dogapp.model

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.GET

interface ApiService {

    @GET("api/breeds/image/random")
    fun getRandomImage(): Call<RandomImage>


    @GET("api/breeds/list/all")
    fun getBreedList(): Call<DogBreedResponse>



    @GET("api/breed/hound/images/random/3")
    fun getRandomImagesByBreed():Call<BreedImageRandom>

}