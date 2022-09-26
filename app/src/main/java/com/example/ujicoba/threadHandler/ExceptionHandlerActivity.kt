package com.example.ujicoba.threadHandler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.ujicoba.databinding.ActivityThreadHandlerBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.*

class ExceptionHandlerActivity : AppCompatActivity() {
    companion object{
        private val TAG = ExceptionHandlerActivity::class.java.simpleName
    }
    private var message = ""
    private lateinit var binding: ActivityThreadHandlerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThreadHandlerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        registerThreadExceptionHandler()

        binding.apply {
            thread.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch {
                    throw MyException()
                }
            }

            coroutine.setOnClickListener {
                CoroutineScope(Dispatchers.Main).launch(coroutineHandler){
                    throw MyException()
                }
            }
        }
    }

    private fun registerThreadExceptionHandler() {
        val originExceptionHandler = Thread.getDefaultUncaughtExceptionHandler()
        Thread.setDefaultUncaughtExceptionHandler { thread, throwable ->
            Log.e(TAG, "Handle Exception", throwable)
            when (throwable) {
                is MyException -> {
                    Log.e(TAG, "registerThreadExceptionHandler: is")
                    showThreadException()
                }
                else -> {
                    Log.e(TAG, "registerThreadExceptionHandler: else")
                    originExceptionHandler?.uncaughtException(thread, throwable)
                }
            }
        }
    }
    private val coroutineHandler = CoroutineExceptionHandler { _, exception ->
        println("CoroutineExceptionHandler got $exception")
        when(exception){
            is MyException -> showCoroutineException()
        }
    }


    private fun showThreadException(){
        Log.e(TAG, "showThreadException: ")
        message = "Thread Exception"
        Snackbar.make(binding.root, "Snack bar thread exception", Snackbar.LENGTH_SHORT).show()
        myDialog.show()
    }

    private val myDialog by lazy {
        MaterialAlertDialogBuilder(this)
            .setTitle("exception")
            .setMessage(message)
            .setPositiveButton(getText(android.R.string.ok)) { dialog, _ ->
                dialog.dismiss()
            }
            .create()
    }

    private fun showCoroutineException(){
        Log.e(TAG, "showCoroutineException: ")
        message = "Coroutine Exception"
        Snackbar.make(binding.root, "Snack bar Coroutine Exception", Snackbar.LENGTH_SHORT).show()
        myDialog.show()
    }
}