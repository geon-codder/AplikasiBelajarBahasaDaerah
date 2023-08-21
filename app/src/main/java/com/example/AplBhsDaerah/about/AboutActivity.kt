package com.example.AplBhsDaerah.about

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.example.AplBhsDaerah.MainActivity
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityAboutBinding
import com.example.AplBhsDaerah.home.HomeActivity

class AboutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAboutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = supportActionBar
        display?.title = "About"
        display?.setDisplayHomeAsUpEnabled(true)

        binding.apply {
            btnAboutToPanduan.setOnClickListener {
                val intent = Intent(this@AboutActivity, CaraPenggunaanAplikasiActivity::class.java)
                startActivity(intent)
            }
            btnAboutToBioDev.setOnClickListener {
                val intent = Intent(this@AboutActivity, BiodataDeveloperActivity::class.java)
                startActivity(intent)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            android.R.id.home ->{
                startActivity(Intent(this, MainActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}