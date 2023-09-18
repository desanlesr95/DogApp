package com.example.dogapp.utils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.dogapp.R


class BindingAdapters {

    companion object{
        @JvmStatic
        @BindingAdapter("setImage")
        fun setImage(view:ImageView, image_url:String){
            Glide.with(view.context)
                .load(image_url)
                .centerCrop()
                .into(view)
        }


        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadingImage(view:ImageView,url:String){
            Glide.with(view.context)
                .load(R.drawable.dog)
                .into(view)
        }



    }




}