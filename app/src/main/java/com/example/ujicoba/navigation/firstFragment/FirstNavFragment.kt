package com.example.ujicoba.navigation.firstFragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ujicoba.R
import com.example.ujicoba.databinding.FragmentFirstNavBinding

class FirstNavFragment : Fragment() {
    private lateinit var binding: FragmentFirstNavBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstNavBinding.inflate(LayoutInflater.from(requireContext()), container, false)
        return binding.root
    }
}