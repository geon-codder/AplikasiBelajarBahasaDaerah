package com.example.AplBhsDaerah.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivitySejarahBahasaDaerahBinding

class SejarahBahasaDaerahActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySejarahBahasaDaerahBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySejarahBahasaDaerahBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply{
            btnSejarahSelesai.setOnClickListener {
                val intent = Intent(this@SejarahBahasaDaerahActivity,HomeActivity::class.java)
                intent.putExtra("SejarahAksaraLontara","done")
                startActivity(intent)
            }
        }

    }
}