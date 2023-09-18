package com.example.dogapp.view.ui.dashboard

import android.app.Dialog
import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.dogapp.databinding.FragmentDashboardBinding
import com.example.dogapp.model.Breed
import com.example.dogapp.presenter.DiscoverPresenter
import java.util.Arrays

class DashboardFragment : Fragment(), DiscoverContract.View {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    lateinit var discoverPresenter: DiscoverContract.Presenter
    lateinit var progressDialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root
        progressDialog = ProgressDialog(context)
        discoverPresenter = DiscoverPresenter(this)
        discoverPresenter.retrieveRandomImage()
        discoverPresenter.retrieveListBreed()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun showImageLoader(url_image: String) {
        Glide.with(this)
            .load(url_image)
            .into(binding.randomImage)
        Log.i("image",url_image);
    }

    override fun showListBreed(breeds: ArrayList<Breed>) {
        binding.rvBreeds.adapter = BreedAdapter(breeds)
    }

    override fun showProgressDialog(message: String) {
        progressDialog.setTitle(message)
        progressDialog.show()
    }

    override fun hideProgressDialog() {
        progressDialog.hide()
    }


}