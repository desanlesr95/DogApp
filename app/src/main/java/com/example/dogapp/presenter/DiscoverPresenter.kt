package com.example.dogapp.presenter

import com.example.dogapp.utils.Utils
import com.example.dogapp.model.repository.ApiService
import com.example.dogapp.model.entitiy.Breed
import com.example.dogapp.model.DogBreedResponse
import com.example.dogapp.model.RandomImage
import com.example.dogapp.utils.singleton.RetrofitSingleton
import com.example.dogapp.view.ui.dashboard.DiscoverContract
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscoverPresenter(private val view:DiscoverContract.View):DiscoverContract.Presenter{
    lateinit var apiService: ApiService

    override fun retrieveRandomImage() {
        view.showProgressDialog(Utils.LOAD)
        apiService = RetrofitSingleton().getApiAdapter(Utils.URL_DOG_API)
        apiService.getRandomImage()?.enqueue(object : Callback<RandomImage>{
            override fun onResponse(call: Call<RandomImage>, response: Response<RandomImage>) {
                view.showImageLoader(response.body()!!.message)
                view.hideProgressDialog()
            }

            override fun onFailure(call: Call<RandomImage>, t: Throwable) {
                view.showImageLoader("")
                view.hideProgressDialog()
            }

        })
    }

    override fun retrieveListBreed() {
        val discoverInteractor = DiscoverInteractor(this)
        view.showProgressDialog(Utils.LOAD_LIST_BREED)
        apiService = RetrofitSingleton().getApiAdapter(Utils.URL_DOG_API)
        apiService.getBreedList()?.enqueue(object : Callback<DogBreedResponse>{
            override fun onResponse(call: Call<DogBreedResponse>, response: Response<DogBreedResponse>) {
                discoverInteractor.getBreedList(response.body()!!.message)

            }

            override fun onFailure(call: Call<DogBreedResponse>, t: Throwable) {

            }

        })
    }

    override fun returnBreedList(listofBreeds: ArrayList<Breed>) {
        view.showListBreed(listofBreeds)
        view.hideProgressDialog()
    }
}