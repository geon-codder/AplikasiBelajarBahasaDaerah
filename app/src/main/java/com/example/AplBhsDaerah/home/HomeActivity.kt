package com.example.AplBhsDaerah.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import com.example.AplBhsDaerah.MainActivity
import com.example.AplBhsDaerah.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = supportActionBar
        display?.title = "Home"
        display?.setDisplayHomeAsUpEnabled(true)

        cekActivityComplete()

        binding.apply {
            btnSejarahBhsDaerah.setOnClickListener {
                val intent = Intent(this@HomeActivity,SejarahBahasaDaerahActivity::class.java)
                startActivity(intent)
            }
            btnKelas.setOnClickListener {
                val intent = Intent(this@HomeActivity,Kelas4Activity::class.java)
                startActivity(intent)
            }
        }
    }

    fun cekActivityComplete(){
        val donechecker=intent.getStringExtra("SejarahAksaraLontara")
        if(donechecker == "done"){
            onBackPressedDispatcher.addCallback(this,onBackInvokedCallback)
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

    override fun onBackPressed(){
        super.onBackPressed()
    }

    private val onBackInvokedCallback = object : OnBackPressedCallback(true){
        override fun handleOnBackPressed(){
            Log.d("onBack", "Exit to Home")
        }
    }



}