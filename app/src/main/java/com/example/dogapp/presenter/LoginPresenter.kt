package com.example.dogapp.presenter

import android.content.Context
import com.example.dogapp.model.repository.ApiService
import com.example.dogapp.model.LoginResponse
import com.example.dogapp.model.entitiy.User
import com.example.dogapp.model.repository.ApiPet
import com.example.dogapp.utils.Utils
import com.example.dogapp.utils.singleton.AppDatabase
import com.example.dogapp.utils.singleton.RetrofitSingleton
import com.example.dogapp.view.LoginContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginPresenter(private val view: LoginContract.View,private val  context: Context) : LoginContract.Presenter{

    lateinit var apiService: ApiService
    lateinit var appDatabase: AppDatabase
    override fun checkCredentials(username: String, password: String) {
        apiService = RetrofitSingleton().getApiAdapter(ApiPet.BASE_URL)
        apiService.getLogin(username,password).enqueue(object :Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                println("lo1 $response")
                if (response.code() == 200){
                    return view.responseLogin(response.body()!!)

                }
                return view.responseLogin(null)
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                println("l2 ${t.message}")
                return view.responseLogin(null)
            }
        })
    }

    override fun saveUserDB(user: User) {
        appDatabase = AppDatabase.getInstance(context)
        appDatabase.getUserDao().insertUser(user)
        view.loggedActive(true)
        appDatabase.close()
    }

    override fun isLogged() {
        appDatabase = AppDatabase.getInstance(context)
        if (appDatabase.getUserDao().getUserLogged()!=0){
            view.loggedActive(true)
        }
        view.loggedActive(false)
    }


}