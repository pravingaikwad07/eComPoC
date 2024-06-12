package com.praving.bareztechecom.poc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.praving.bareztechecom.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Timber.d("App launched!")
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}