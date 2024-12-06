package com.example.dogapp.view.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.TextView
import android.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dogapp.databinding.FragmentHomeBinding
import com.example.dogapp.model.entitiy.Pet
import com.example.dogapp.model.repository.ApiService

class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private var  _binding: FragmentHomeBinding? = null
    private lateinit var petListAdapter: PetListAdapter
   // private lateinit var service: ApiService

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         viewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val toolbar:Toolbar


       // setupAdapter()
        //setupRecyclearView()

      /*  val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        petListAdapter = PetListAdapter(emptyList())
        _binding!!.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        _binding!!.recyclerView.adapter = petListAdapter

        //cofiguracion de recyclerview y su adaptaodr
       // _binding!!.recyclerView.layoutManager = LinearLayoutManager(context)
        // petListAdapter = PetListAdapter(listOf())



        // Llama al método en el ViewModel para obtener la lista de mascotas
       viewModel.getPet(1) // Reemplaza 123 con el ID adecuado según tu caso
        // viewModel.getPet(id)

        // Observa los cambios en la lista de mascotas desde el ViewModel k
       viewModel.pets.observe(viewLifecycleOwner, Observer { petList ->
           Log.d("per",petList.toString())
           //actualiza la ui con los datos obtenidos
           viewModel.insertarPet(petList,requireContext())
           val pets = viewModel.getpetwithphoto(requireContext())
           petListAdapter.updateData(pets)
        })

        viewModel.error.observe(viewLifecycleOwner, Observer { error ->
            //muestra el mensaje de error en la ui
        })


      // _binding.reci
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


 /*   private fun setupAdapter(){
       petListAdapter = PetListAdapter()
    }*/
    /*private fun setupRecyclerView(results: List<Pet>){
        val adapter = ListAdapter(results as ArrayList )
     _binding.re

    }*/
      /*  _binding.recyclerView.layoutManager = LinearLayoutManager(context)
        petListAdapter = PetListAdapter(listOf())
        _binding.reci*/




}