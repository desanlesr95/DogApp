package com.example.dogapp.model.repository

import com.example.dogapp.utils.singleton.RetrofitSingleton
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiPet {

     const val  BASE_URL ="http://162.241.101.130:8000/"

     val instance : ApiService by lazy {
          Retrofit.Builder()
               .baseUrl(BASE_URL)
               .addConverterFactory(GsonConverterFactory.create())
               .build().create(ApiService::class.java)

     }

}