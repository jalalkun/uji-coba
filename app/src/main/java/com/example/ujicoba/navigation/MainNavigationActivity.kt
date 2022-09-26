package com.example.ujicoba.navigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ujicoba.databinding.ActivityMainNavigationBinding

class MainNavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}