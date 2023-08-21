package com.example.AplBhsDaerah.home.sub.bab4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.AplBhsDaerah.databinding.ActivityMenyimak4Binding
import com.example.AplBhsDaerah.game.GameActivity
import com.example.AplBhsDaerah.home.sub.SubBab4Activity
import com.example.AplBhsDaerah.home.sub.bab6.Berbicara6Activity
import com.geco.zhyskaapp.data.BarisSoal
import com.geco.zhyskaapp.data.Soal
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Menyimak4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMenyimak4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenyimak4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply{
            btnCekJawabanMenyimak4.setOnClickListener{
                cekJawaban()
            }
            btnMenyimak4Selesai.setOnClickListener {
                val jawaban1a = inputJawabanMenyimak4no1a.text.toString()
                val jawaban1b = inputJawabanMenyimak4no1b.text.toString()
                val jawaban1c = inputJawabanMenyimak4no1c.text.toString()
                val jawaban1d = inputJawabanMenyimak4no1d.text.toString()
                val jawaban1e = inputJawabanMenyimak4no1e.text.toString()
                val jawaban2 = inputJawabanMenyimak4no2.text.toString()
                val jawaban3 = inputJawabanMenyimak4no3.text.toString()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()
                cekSkor()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor
                val activityStatus = "done"

                val skorMenyimak4 = pref.getInt("menyimak4", 0)

                if(skorMenyimak4 == 0){
                    editor.putInt("menyimak4", skorAkhir)
                    editor.apply()
                    Toast.makeText(this@Menyimak4Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }
                skor = 0
                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1a")
                        .setValue(jawaban1a)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1b")
                        .setValue(jawaban1b)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1c")
                        .setValue(jawaban1c)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1d")
                        .setValue(jawaban1d)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak1e")
                        .setValue(jawaban1e)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("menyimak3")
                        .setValue(jawaban3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menyimak4").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menyimak4").setValue(activityStatus)

                }
                val intent = Intent(this@Menyimak4Activity, SubBab4Activity::class.java)
                startActivity(intent)
            }

            dragLinearLayout2.apply {
                setContainerScrollView(scrollView2)
                setOnViewSwapListener { _, startPosition, _, endPosition ->
                    swapElements(startPosition, endPosition)
                }
            }
            addArtiBhsLontara.forEach {
                addRow(it)
            }
        }
    }

    private fun cekJawaban(){
        if(addArtiBhsLontara[0].toString() == "Soal(kodeSoal=L11N1, teksSoal== Bosan)"){
            binding.tva1.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva1.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[1].toString() == "Soal(kodeSoal=L11N2, teksSoal== Membosankan)"){
            binding.tva2.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva2.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[2].toString() == "Soal(kodeSoal=L11N3, teksSoal== Sudah bosan)"){
            binding.tva3.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva3.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[3].toString() == "Soal(kodeSoal=L11N4, teksSoal== Manja)"){
            binding.tva4.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva4.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[4].toString() == "Soal(kodeSoal=L11N5, teksSoal== Dimanjakan)"){
            binding.tva5.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva5.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[5].toString() == "Soal(kodeSoal=L11N6, teksSoal== Saling memanjakan)"){
            binding.tva6.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva6.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[6].toString() == "Soal(kodeSoal=L11N7, teksSoal== Menghujat)"){
            binding.tva7.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva7.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[7].toString() == "Soal(kodeSoal=L11N8, teksSoal== kaya)"){
            binding.tva8.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva8.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[8].toString() == "Soal(kodeSoal=L11N9, teksSoal== miskin)"){
            binding.tva9.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva9.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[9].toString() == "Soal(kodeSoal=L11N10, teksSoal== kebaikan)"){
            binding.tva10.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva10.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[10].toString() == "Soal(kodeSoal=L11N11, teksSoal== pada akhirnya)"){
            binding.tva11.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva11.setBackgroundColor(Color.WHITE)
        }
        if(addArtiBhsLontara[11].toString() == "Soal(kodeSoal=L11N12, teksSoal== hari kemudian)"){
            binding.tva12.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva12.setBackgroundColor(Color.WHITE)
        }
    }

    private fun cekSkor(){
        if(addArtiBhsLontara[0].toString() == "Soal(kodeSoal=L11N1, teksSoal== Bosan)"){
            skor += 10
        }
        if(addArtiBhsLontara[1].toString() == "Soal(kodeSoal=L11N2, teksSoal== Membosankan)"){
            skor += 10
        }
        if(addArtiBhsLontara[2].toString() == "Soal(kodeSoal=L11N3, teksSoal== Sudah bosan)"){
            skor += 10
        }
        if(addArtiBhsLontara[3].toString() == "Soal(kodeSoal=L11N4, teksSoal== Manja)"){
            skor += 10
        }
        if(addArtiBhsLontara[4].toString() == "Soal(kodeSoal=L11N5, teksSoal== Dimanjakan)"){
            skor += 10
        }
        if(addArtiBhsLontara[5].toString() == "Soal(kodeSoal=L11N6, teksSoal== Saling memanjakan)"){
            skor += 10
        }
        if(addArtiBhsLontara[6].toString() == "Soal(kodeSoal=L11N7, teksSoal== Menghujat)"){
            skor += 10
        }
        if(addArtiBhsLontara[7].toString() == "Soal(kodeSoal=L11N8, teksSoal== kaya)"){
            skor += 10
        }
        if(addArtiBhsLontara[8].toString() == "Soal(kodeSoal=L11N9, teksSoal== miskin)"){
            skor += 10
        }
        if(addArtiBhsLontara[9].toString() == "Soal(kodeSoal=L11N10, teksSoal== kebaikan)"){
            skor += 10
        }
        if(addArtiBhsLontara[10].toString() == "Soal(kodeSoal=L11N11, teksSoal== pada akhirnya)"){
            skor += 10
        }
        if(addArtiBhsLontara[11].toString() == "Soal(kodeSoal=L11N12, teksSoal== hari kemudian)"){
            skor += 10
        }
    }

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    private fun addRow(soal: Soal) {
        BarisSoal(this).run row@{
            initRow(soal)
            binding.dragLinearLayout2.run {
                addView(this@row)
                setViewDraggable(this@row, this@row)
            }
        }
    }

    private fun swapElements(startPosition: Int, endPosition: Int) {
        addArtiBhsLontara.run {
            this[startPosition] = this[endPosition].also {
                this[endPosition] = this[startPosition]
            }
        }
    }

    companion object {
        private val addArtiBhsLontara = mutableListOf(
            Soal("L11N1","= Bosan"),
            Soal("L11N4","= Manja"),
            Soal("L11N8","= kaya"),
            Soal("L11N5","= Dimanjakan"),
            Soal("L11N3","= Sudah bosan"),
            Soal("L11N6","= Saling memanjakan"),
            Soal("L11N2","= Membosankan"),
            Soal("L11N7","= Menghujat"),
            Soal("L11N10","= kebaikan"),
            Soal("L11N11","= pada akhirnya"),
            Soal("L11N9","= miskin"),
            Soal("L11N12","= hari kemudian")
        )
        var skor = 0
    }
}