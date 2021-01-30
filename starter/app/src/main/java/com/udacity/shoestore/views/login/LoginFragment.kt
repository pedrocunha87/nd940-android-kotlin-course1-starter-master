package com.udacity.shoestore.views.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: LoginFragmentBinding = DataBindingUtil
            .inflate(
                inflater, R.layout.login_fragment, container, false
            )

        binding
            .btNewLogin
            .setOnClickListener {
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginToWelcome())
            }

        binding
            .btLogin
            .setOnClickListener {
                findNavController()
                    .navigate(LoginFragmentDirections.actionLoginToWelcome())
            }
        return binding.root
    }
}