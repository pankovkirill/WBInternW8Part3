package com.example.wbinternw8part3.view.aboutapp

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.wbinternw8part3.R
import com.example.wbinternw8part3.databinding.FragmentAboutAppBinding

class AboutAppFragment : Fragment(R.layout.fragment_about_app) {

    private lateinit var binding: FragmentAboutAppBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAboutAppBinding.bind(view)

        binding.alphaContainer.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.accept.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}