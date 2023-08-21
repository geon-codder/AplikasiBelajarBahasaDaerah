package com.example.AplBhsDaerah.about

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityBiodataDeveloperBinding

class BiodataDeveloperActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBiodataDeveloperBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBiodataDeveloperBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }
    }
}