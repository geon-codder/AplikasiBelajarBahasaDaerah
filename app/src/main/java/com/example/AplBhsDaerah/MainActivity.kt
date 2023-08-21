package com.example.AplBhsDaerah

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.AplBhsDaerah.about.AboutActivity
import com.example.AplBhsDaerah.auth.LoginActivity
import com.example.AplBhsDaerah.data.Skor
import com.example.AplBhsDaerah.databinding.ActivityMainBinding
import com.example.AplBhsDaerah.game.GameActivity
import com.example.AplBhsDaerah.home.HomeActivity
import com.example.AplBhsDaerah.home.sub.bab4.Berbicara4Activity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initFirebaseAuth()
        getData()

        binding.apply {
            btnHome.setOnClickListener {
                val intent = Intent(this@MainActivity, HomeActivity::class.java)
                startActivity(intent)
            }

            btnProfil.setOnClickListener {
                val intent = Intent(this@MainActivity, ProfilActivity::class.java)
//                val intent = Intent(this@MainActivity, GameActivity::class.java)
                startActivity(intent)
            }

            btnAbout.setOnClickListener {
                val intent = Intent(this@MainActivity, AboutActivity::class.java)
                intent.putExtra("assetName", "defaultimage.png")
                startActivity(intent)
            }

            btnLogout.setOnClickListener {
                val sharedPreference =  getSharedPreferences("login", Context.MODE_PRIVATE)
                val sharedPreferenceSkor =  getSharedPreferences("Skor", Context.MODE_PRIVATE)
                val editor = sharedPreference.edit()
                val skorEditor = sharedPreferenceSkor.edit()
                editor.remove("isUserLogin")
                skorEditor.remove("puzzle4")
                skorEditor.remove("menyimak4")
                skorEditor.remove("menulis4")
                skorEditor.remove("membaca4")
                skorEditor.remove("berbicara4")

                skorEditor.remove("puzzle5")
                skorEditor.remove("menyimak5")
                skorEditor.remove("menulis5")
                skorEditor.remove("membaca5")
                skorEditor.remove("berbicara5")

                skorEditor.remove("puzzle6")
                skorEditor.remove("menyimak6")
                skorEditor.remove("menulis6")
                skorEditor.remove("membaca6")
                skorEditor.remove("berbicara6")

                editor.apply()
                auth.signOut()
                val intent = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun getData() {
        val user = auth.currentUser
        if(user != null){
            val namaPengguna = user.email
            Toast.makeText(this@MainActivity, "Selamat datang user $namaPengguna ", Toast.LENGTH_LONG).show()
        }
    }

    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()
    }
}