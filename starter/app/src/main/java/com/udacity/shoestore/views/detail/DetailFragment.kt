package com.udacity.shoestore.views.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.DetailFragmentBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.views.list.ListViewModel

class DetailFragment : Fragment() {

    private val listViewModel: ListViewModel by activityViewModels()

    private var shoe = Shoe("", 35.0, "", "")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: DetailFragmentBinding = DataBindingUtil
            .inflate(
                inflater, R.layout.detail_fragment, container, false
            )

        binding.shoe = shoe

        binding
            .btCancel
            .setOnClickListener {
                findNavController().navigateUp()
            }

        binding
            .btSave
            .setOnClickListener {
                listViewModel.addShoe(shoe)
                findNavController().navigateUp()
            }

        return binding.root
    }
}