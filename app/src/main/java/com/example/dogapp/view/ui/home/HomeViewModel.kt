package com.example.dogapp.view.ui.home

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogapp.model.entitiy.Pet
import com.example.dogapp.model.entitiy.PetWithPhoto
import com.example.dogapp.model.repository.ApiPet
import com.example.dogapp.model.repository.ApiService
import com.example.dogapp.utils.singleton.AppDatabase
import com.example.dogapp.utils.singleton.RetrofitSingleton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class HomeViewModel : ViewModel() {
  private lateinit var service: ApiService

  private val _pet = MutableLiveData<List<Pet>>()
   val pets: LiveData<List<Pet>> = _pet

   private val _error = MutableLiveData<String>()
   val error: LiveData<String> = _error

   fun getPet(id:Int){
      viewModelScope.launch (Dispatchers.IO){
               try {
                service = ApiPet.instance
                   val response = service.getPetList(id)

                  if (response.isSuccessful){
                   viewModelScope.launch(Dispatchers.Main) { _pet.value = response.body() }

                  }else{
                   viewModelScope.launch(Dispatchers.Main){ _error.value = "Error:${response.code()}"}

                  }
               }catch (e:Exception){
                viewModelScope.launch(Dispatchers.Main){ _error.value  = "Error: ${e.message}"}

               }



      }
   }

    fun insertarPet(pets: List<Pet>,context:Context){
        var database = AppDatabase.getInstance(context)
        for (pet in pets){
            val id = database.getPetDao().insertRecentProfilePhone(pet.profilePhoto!!)
            pet.RecentProfilePhoto_id = id.toInt()
            database.getPetDao().insertPet(pet)
        }

    }


    fun getpetwithphoto(context: Context): List<PetWithPhoto>{
        var database = AppDatabase.getInstance(context)
        return database.getPetDao().getPetWithPhotoAll()
    }



}