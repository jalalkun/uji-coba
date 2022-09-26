package com.example.ujicoba.navigation.secondFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ujicoba.R
import com.example.ujicoba.databinding.FragmentSecondNavBinding


class SecondNavFragment : Fragment() {
    private lateinit var binding: FragmentSecondNavBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondNavBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }
}