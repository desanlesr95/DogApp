package com.example.dogapp.view.ui.dashboard

import com.example.dogapp.model.entitiy.Breed

interface DiscoverContract {
    interface View{
        fun showImageLoader(url_image:String)
        fun showListBreed(breeds:ArrayList<Breed>)
        fun showProgressDialog(message:String)
        fun hideProgressDialog()
    }

    interface Presenter{
        fun retrieveRandomImage()
        fun retrieveListBreed()
        fun returnBreedList(listofBreeds:ArrayList<Breed>)
    }

    interface Interactor{
        fun getBreedList(breedMap:HashMap<String,List<String>>)
    }




}