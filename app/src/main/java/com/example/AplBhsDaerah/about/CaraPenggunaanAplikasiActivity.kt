package com.example.AplBhsDaerah.about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityCaraPenggunaanAplikasiBinding
import com.example.AplBhsDaerah.home.HomeActivity

class CaraPenggunaanAplikasiActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCaraPenggunaanAplikasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCaraPenggunaanAplikasiBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply{
            btnPenggunaanAplikasiSelesai.setOnClickListener {
                val intent = Intent(this@CaraPenggunaanAplikasiActivity, AboutActivity::class.java)
                intent.putExtra("SejarahAksaraLontara","done")
                startActivity(intent)
            }
        }
    }
}