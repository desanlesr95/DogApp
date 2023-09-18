package com.example.dogapp.presenter

import android.util.Log
import com.example.dogapp.model.ApiService
import com.example.dogapp.model.Breed
import com.example.dogapp.model.BreedImageRandom
import com.example.dogapp.utils.Utils
import com.example.dogapp.utils.retrofit.RetrofitAdapter
import com.example.dogapp.view.ui.dashboard.DiscoverContract
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DiscoverInteractor(val discoverPresenter: DiscoverPresenter):DiscoverContract.Interactor {
    lateinit var apiService: ApiService

    override fun getBreedList(breedMap: HashMap<String, List<String>>) {
        apiService = RetrofitAdapter().getApiAdapter(Utils.URL_DOG_API)
        var listOfBreed = ArrayList<Breed>()
        runBlocking {
            breedMap.forEach {
                    (breed,subreed)->
                    launch(Dispatchers.IO){
                        try {
                            val response = apiService.getRandomImagesByBreed().execute()

                            if (response.isSuccessful) {
                                val breedImageRandom = response.body()
                                listOfBreed.add(Breed(breed,subreed,breedImageRandom!!.message))
                            } else {

                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                //listOfBreed = Breed(breed,subreed)

            }
            discoverPresenter.returnBreedList(listOfBreed)
        }
    }


}