package com.example.ujicoba

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.ujicoba.databinding.ActivityMainBinding
import com.example.ujicoba.threadHandler.ExceptionHandlerActivity
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    companion object{
        private val TAG = MainActivity::class.java.simpleName
    }
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        sharedPreferences = getSharedPreferences("my_preference", MODE_PRIVATE)
        with(sharedPreferences.edit()){
            putString("myString", "ini stringku")
            apply()
        }

        binding.apply {
            toExceptionHandler.setOnClickListener {
                startActivity(Intent(this@MainActivity, ExceptionHandlerActivity::class.java))
            }
        }

        val text = "[\"Floor 0\",\"Floor 1\",\"Floor 2\"]"
        val array = Gson().fromJson(text, ArrayList::class.java)
        array.forEach {
            Log.e(TAG, "onCreate: it $it")
        }
    }
}