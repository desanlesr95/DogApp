package com.example.dogapp.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.request.RequestOptions
import com.example.dogapp.R
import com.example.dogapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Glide.with(this)
            .load(R.drawable.dog)
            .apply(RequestOptions.bitmapTransform(CircleCrop()))
            .into(binding.dog)

        binding.btnLogin.setOnClickListener(object : View.OnClickListener{
            override fun onClick(p0: View?) {
                startActivity(Intent(applicationContext,Home::class.java))
                finish()
            }

        })

    }
}