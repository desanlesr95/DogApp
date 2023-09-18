package com.example.dogapp.model

class Breed(val name:String,val subBreed:List<String>,var images:List<String>){
    override fun toString(): String {
        return "Breed(name='$name', subBreed=$subBreed, images=$images)"
    }
}