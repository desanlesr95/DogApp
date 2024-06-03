package com.example.dogapp.view.ui.dashboard

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dogapp.databinding.CardBreedBinding
import com.example.dogapp.model.entitiy.Breed

class BreedAdapter(var listOfBreeds: ArrayList<Breed>):RecyclerView.Adapter<BreedAdapter.ViewHolder>() {
   var binding: CardBreedBinding ?= null


    class ViewHolder(view:CardBreedBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        this.binding = CardBreedBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(this.binding!!)
    }

    override fun getItemCount(): Int {
        return listOfBreeds.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding!!.breed = listOfBreeds.get(position)
        binding!!.executePendingBindings()
    }
}