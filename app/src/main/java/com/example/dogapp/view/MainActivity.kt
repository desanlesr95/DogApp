package com.example.dogapp.view

import PetiverseToast
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.dogapp.R
import com.example.dogapp.databinding.ActivityMainBinding
import com.example.dogapp.model.LoginResponse
import com.example.dogapp.presenter.LoginPresenter


class MainActivity : AppCompatActivity(),LoginContract.View{
    lateinit var binding:ActivityMainBinding
    lateinit var presenter: LoginContract.Presenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Glide.with(this)
            .load(R.drawable.dog)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(binding.dog)
        presenter = LoginPresenter(this,applicationContext)
        presenter.isLogged()
        binding.btnLogin.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                PetiverseToast.showMessage(applicationContext,"Validando credenciales...", isProgress = true)
                presenter.checkCredentials(binding.username.text.toString(),binding.password.text.toString())
            }
        })

    }

    override fun responseLogin(response: LoginResponse?) {
        PetiverseToast.dismiss()
        if(response == null){
            PetiverseToast.showMessage(this,"Credenciales incorrectas",Toast.LENGTH_SHORT)
        }else{
            var user = response!!.user
            user.token = response!!.token
            presenter.saveUserDB(user)
            PetiverseToast.showMessage(this,"Credenciales correctas",Toast.LENGTH_SHORT)
        }

    }

    override fun loggedActive(logged: Boolean) {
       if (logged){
           startActivity(Intent(applicationContext,Home::class.java))
           finish()
       }
    }
}