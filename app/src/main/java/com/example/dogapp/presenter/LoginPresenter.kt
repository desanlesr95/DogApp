package com.example.dogapp.presenter

import android.content.Context
import com.example.dogapp.model.repository.ApiService
import com.example.dogapp.model.LoginResponse
import com.example.dogapp.model.entitiy.User
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
        apiService = RetrofitSingleton().getApiAdapter(Utils.URL_DOGAPP_API)
        apiService.getLogin(username,password).enqueue(object :Callback<LoginResponse>{
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                return view.responseLogin(response.body()!!)
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                println(t.message.toString())
                return view.responseLogin(null)
            }
        })
    }

    override fun saveUserDB(user: User) {
        appDatabase = AppDatabase.geInstance(context)
        appDatabase.getUserDao().insertUser(user)
        view.loggedActive(true)
        appDatabase.close()
    }

    override fun isLogged() {
        appDatabase = AppDatabase.geInstance(context)
        if (appDatabase.getUserDao().getUserLogged()!=0){
            view.loggedActive(true)
        }
        view.loggedActive(false)
    }


}