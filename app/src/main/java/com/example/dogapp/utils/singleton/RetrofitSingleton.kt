package com.example.dogapp.utils.singleton

import com.example.dogapp.model.repository.ApiService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitSingleton {
    lateinit var okHttpClient:OkHttpClient

   constructor(){
       okHttpClient = OkHttpClient.Builder()
           .addInterceptor(HttpLoggingInterceptor().apply {
               level = HttpLoggingInterceptor.Level.BODY
           })
           .connectTimeout(30, TimeUnit.SECONDS) // Establece un tiempo máximo de espera de 30 segundos
           .writeTimeout(2000, TimeUnit.SECONDS)
           .readTimeout(3000, TimeUnit.SECONDS)
           .build()
   }

    fun  getApiAdapter(urlApi:String): ApiService {
        val retrofit = Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(urlApi)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return  retrofit.create(ApiService::class.java)

    }


}