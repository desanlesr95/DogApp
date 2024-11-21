package com.example.dogapp.view.ui.home

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.dogapp.databinding.CardPetBinding
import com.example.dogapp.model.entitiy.Pet
import com.example.dogapp.model.entitiy.PetWithPhoto
import com.example.dogapp.model.entitiy.RecentProfilePhoto
import com.example.dogapp.model.repository.ApiPet
import com.squareup.picasso.Picasso

class PetListAdapter (private var pet: List<PetWithPhoto>):RecyclerView.Adapter<PetListAdapter.PetViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        val binding = CardPetBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PetViewHolder(binding)
    }

    override fun getItemCount(): Int = pet.size

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        holder.bind(pet[position])

    }

     fun updateData(newPetList: List<PetWithPhoto>){
         pet =  newPetList
         notifyDataSetChanged()
     }
    class  PetViewHolder(private  val binding: CardPetBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(pet: PetWithPhoto){
            loadImage(binding.imgpet, pet.recentProfilePhoto!!.url_photo)
            binding.tvnombre.text = pet.pet.name
            binding.tvtipo.text = pet.pet.pet_type.toString()
            binding.tvano.text = pet.pet.age.toString()
            binding.tvraza.text = pet.pet.breed
            binding.tvcolor.text = pet.pet.color
            binding.tvgenero.text = pet.pet.gender.toString()
        }
        private fun loadImage(imgPet: ImageView,urlpet:String){
            val url = "${ApiPet.BASE_URL}/api$urlpet"
            println(url)
            Picasso.get()
                .load(url)
                .into(imgPet)
        }
    }




}