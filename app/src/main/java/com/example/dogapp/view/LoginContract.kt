package com.example.dogapp.view

import android.content.Context
import com.example.dogapp.model.LoginResponse
import com.example.dogapp.model.entitiy.User

interface LoginContract {
    interface View{
        fun responseLogin(response: LoginResponse?)
        fun loggedActive(logged:Boolean)
    }


    interface Presenter{
        fun checkCredentials(username:String,password:String)
        fun saveUserDB(user:User)
        fun isLogged()
    }

}