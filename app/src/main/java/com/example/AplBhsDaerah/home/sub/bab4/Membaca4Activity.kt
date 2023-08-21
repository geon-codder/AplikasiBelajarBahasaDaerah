package com.example.AplBhsDaerah.home.sub.bab4

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.data.KalimatSoal
import com.example.AplBhsDaerah.databinding.ActivityMembaca4Binding
import com.example.AplBhsDaerah.game.GameActivity
import com.example.AplBhsDaerah.home.sub.SubBab4Activity
import com.example.AplBhsDaerah.home.sub.bab6.Berbicara6Activity
import com.geco.zhyskaapp.data.BarisSoal
import com.geco.zhyskaapp.data.Soal
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class Membaca4Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMembaca4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMembaca4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {
            tvl1Membaca4.setOnClickListener{
                ctvl1 += 1
                tvl1Membaca4.setBackgroundColor(getResources().getColor(R.color.number_1))
                if (ctvl1 == 2){
                    tvl1Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl1 = 0
                    ctva1 = 0
                }
            }
            tva1Membaca4.setOnClickListener{
                ctva1 += 1

                if(ctvl1 == 1 && ctva1 == 1){
                    ivl1a1.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if (ctva1 == 2){
                    tvl1Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl1 = 0
                    ctva1 = 0
                }
            }


            tvl2Membaca4.setOnClickListener{
                ctvl2 += 1
                tvl2Membaca4.setBackgroundColor(getResources().getColor(R.color.number_2))

                if( ctvl2 == 2){
                    tvl2Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl2 = 0
                    ctva2 = 0
                }
            }
            tva2Membaca4.setOnClickListener{
                ctva2 += 1

                if(ctvl2 == 1 && ctva2 == 1){
                    ivl2a2.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva2 == 2){
                    tvl2Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl2 = 0
                    ctva2 = 0
                }
            }


            tvl3Membaca4.setOnClickListener{
                ctvl3 += 1
                tvl3Membaca4.setBackgroundColor(getResources().getColor(R.color.number_3))
                if( ctvl3 == 2){
                    tvl3Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl3 = 0
                    ctva3 = 0
                }
            }
            tva3Membaca4.setOnClickListener{
                ctva3 += 1

                if(ctvl3 == 1 && ctva3 == 1){
                    ivl3a3.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva3 == 2){
                    tvl3Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl3 = 0
                    ctva3 = 0
                }
            }


            tvl4Membaca4.setOnClickListener{
                ctvl4 += 1
                tvl4Membaca4.setBackgroundColor(getResources().getColor(R.color.number_4))

                if( ctvl4 == 2){
                    tvl4Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl4 = 0
                    ctva4 = 0
                }
            }
            tva4Membaca4.setOnClickListener{
                ctva4 += 1

                if(ctvl4 == 1 && ctva4 == 1){
                    ivl4a4.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva4 == 2){
                    tvl4Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl4 = 0
                    ctva4 = 0
                }
            }

            tvl5Membaca4.setOnClickListener{
                ctvl5 += 1
                tvl5Membaca4.setBackgroundColor(getResources().getColor(R.color.number_5))

                if( ctvl5 == 2){
                    tvl5Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl5 = 0
                    ctva5 = 0
                }
            }
            tva5Membaca4.setOnClickListener{
                ctva5 += 1
                if(ctvl5 == 1 && ctva5 == 1){
                    ivl5a5.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva5 == 2){
                    tvl5Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl5 = 0
                    ctva5 = 0
                }
            }


            tvl6Membaca4.setOnClickListener{
                ctvl6 += 1
                tvl6Membaca4.setBackgroundColor(getResources().getColor(R.color.number_1))

                if( ctvl6 == 2){
                    tvl6Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl6 = 0
                    ctva6 = 0
                }
            }
            tva6Membaca4.setOnClickListener{
                ctva6 += 1

                if(ctvl6 == 1 && ctva6 == 1){
                    ivl6a6.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva6 == 2){
                    tvl6Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl6 = 0
                    ctva6 = 0
                }
            }


            tvl7Membaca4.setOnClickListener{
                ctvl7 += 1
                tvl7Membaca4.setBackgroundColor(getResources().getColor(R.color.number_2))

                if( ctvl7 == 2){
                    tvl7Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl7 = 0
                    ctva7 = 0
                }
            }
            tva7Membaca4.setOnClickListener{
                ctva7 += 1

                if(ctvl7 == 1 && ctva7 == 1){
                    ivl7a7.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva7 == 2){
                    tvl7Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl7 = 0
                    ctva7 = 0
                }
            }

            tvl8Membaca4.setOnClickListener{
                ctvl8 += 1
                tvl8Membaca4.setBackgroundColor(getResources().getColor(R.color.number_3))

                

                if( ctvl8 == 2){
                    tvl8Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl8 = 0
                    ctva8 = 0
                }
            }
            tva8Membaca4.setOnClickListener{
                ctva8 += 1

                if(ctvl8 == 1 && ctva8 == 1){
                    ivl8a8.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }
                
                if( ctva8 == 2){
                    tvl8Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl8 = 0
                    ctva8 = 0
                }
            }



            tvl9Membaca4.setOnClickListener{
                ctvl9 += 1
                tvl9Membaca4.setBackgroundColor(getResources().getColor(R.color.number_4))

                if( ctvl9 == 2){
                    tvl9Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl9 = 0
                    ctva9 = 0
                }
            }
            tva9Membaca4.setOnClickListener{
                ctva9 += 1

                if(ctvl9 == 1 && ctva9 == 1){
                    ivl9a9.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva9 == 2){
                    tvl9Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl9 = 0
                    ctva9 = 0
                }
            }


            tvl10Membaca4.setOnClickListener{
                ctvl10 += 1
                tvl10Membaca4.setBackgroundColor(getResources().getColor(R.color.number_5))

                if( ctvl10 == 2){
                    tvl10Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl10 = 0
                    ctva10 = 0
                }
            }
            tva10Membaca4.setOnClickListener{
                ctva10 += 1

                if(ctvl10 == 1 && ctva10 == 1){
                    ivl10a10.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva10 == 2){
                    tvl10Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl10 = 0
                    ctva10 = 0
                }
            }


            tvl11Membaca4.setOnClickListener{
                ctvl11 += 1
                tvl11Membaca4.setBackgroundColor(getResources().getColor(R.color.number_2))

                if( ctvl11 == 2){
                    tvl11Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl11 = 0
                    ctva11 = 0
                }
            }
            tva11Membaca4.setOnClickListener{
                ctva11 += 1

                if(ctvl11 == 1 && ctva11 == 1){
                    ivl12a12.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva11 == 2){
                    tvl11Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl11 = 0
                    ctva11 = 0
                }
            }


            tvl12Membaca4.setOnClickListener{
                ctvl12 += 1
                tvl12Membaca4.setBackgroundColor(getResources().getColor(R.color.number_1))

                if( ctvl12 == 2){
                    tvl12Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl12 = 0
                    ctva12 = 0
                }
            }
            tva12Membaca4.setOnClickListener{
                ctva12 += 1

                if(ctvl12 == 1 && ctva12 == 1){
                    ivl11a11.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva12 == 2){
                    tvl12Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl12 = 0
                    ctva12 = 0
                }
            }


            tvl13Membaca4.setOnClickListener{
                ctvl13 += 1
                tvl13Membaca4.setBackgroundColor(getResources().getColor(R.color.number_3))

                if( ctvl13 == 2){
                    tvl13Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl13 = 0
                    ctva13 = 0
                }
            }
            tva13Membaca4.setOnClickListener{
                ctva13 += 1

                if(ctvl13 == 1 && ctva13 == 1){
                    ivl13a13.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva13 == 2){
                    tvl13Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl13 = 0
                    ctva13 = 0
                }
            }


            tvl14Membaca4.setOnClickListener{
                ctvl14 += 1
                tvl14Membaca4.setBackgroundColor(getResources().getColor(R.color.number_4))

                if( ctvl14 == 2){
                    tvl14Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl14 = 0
                    ctva14 = 0
                }
            }
            tva14Membaca4.setOnClickListener{
                ctva14 += 1

                if(ctvl14 == 1 && ctva14 == 1){
                    ivl14a14.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva14 == 2){
                    tvl14Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl14 = 0
                    ctva14 = 0
                }
            }

            tvl15Membaca4.setOnClickListener{
                ctvl15 += 1
                tvl15Membaca4.setBackgroundColor(getResources().getColor(R.color.number_5))

                if( ctvl15 == 2){
                    tvl15Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl15 = 0
                    ctva15 = 0
                }
            }
            tva15Membaca4.setOnClickListener{
                ctva15 += 1
                if(ctvl15 == 1 && ctva15 == 1){
                    ivl15a15.visibility = View.VISIBLE
                    skor += 5
                    Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +5, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
                }

                if( ctva15 == 2){
                    tvl15Membaca4.setBackgroundColor(getResources().getColor(R.color.white))
                    ctvl15 = 0
                    ctva15 = 0
                }
            }


            btnMembaca4pilgan1a.setOnClickListener {
                btnMembaca4pilgan1a.setBackgroundColor(Color.RED)
            }
            btnMembaca4pilgan1b.setOnClickListener {
                btnMembaca4pilgan1b.setBackgroundColor(Color.RED)
            }
            btnMembaca4pilgan1c.setOnClickListener {
                btnMembaca4pilgan1c.setBackgroundColor(Color.GREEN)
                skor += 10
                Toast.makeText(this@Membaca4Activity, "Jawaban benar, skor +10, Skor saat ini ${skor}", Toast.LENGTH_SHORT).show()
            }
            btnMembaca4pilgan1d.setOnClickListener {
                btnMembaca4pilgan1d.setBackgroundColor(Color.RED)
            }


            btnCekJawabanMembaca4.setOnClickListener {
                cekJawaban()
            }

            btnMembaca4Selesai.setOnClickListener {
                val jawaban1 = inputJawabanMembaca4no1.text.toString()
                val jawaban2 = inputJawabanMembaca4no2.text.toString()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()
                cekSkor()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor
                val activityStatus = "done"

                val skorMembaca4 = pref.getInt("membaca4", 0)

                if (skorMembaca4 == 0){
                    editor.putInt("membaca4", skorAkhir)
                    editor.apply()
                    Toast.makeText(this@Membaca4Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }
                skor = 0

                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("membaca1")
                        .setValue(jawaban1)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab4").child("membaca2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("membaca4").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("membaca4").setValue(activityStatus)
                }


                val intent = Intent(this@Membaca4Activity, SubBab4Activity::class.java)
                startActivity(intent)
            }

            dragLinearLayout2.apply {
                setContainerScrollView(scrollView2)
                setOnViewSwapListener { _, startPosition, _, endPosition ->
                    swapElements(startPosition, endPosition)
                }
            }

            addKataUlang.forEach {
                addRow(it)
            }
        }
    }
    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    private fun cekSkor(){

        if(addKataUlang[0].toString() == "Soal(kodeSoal=L31N1, teksSoal== Akballak-ballak)"){
            skor += 10
        }
        if(addKataUlang[1].toString() == "Soal(kodeSoal=L31N2, teksSoal== Akkelong-kelong)"){
            skor += 10
        }
        if(addKataUlang[2].toString() == "Soal(kodeSoal=L31N3, teksSoal== Akkarek-karena)"){
            skor += 10
        }
        if(addKataUlang[3].toString() == "Soal(kodeSoal=L31N4, teksSoal== Akballe-balle)"){
            skor += 10
        }
        if(addKataUlang[4].toString() == "Soal(kodeSoal=L31N5, teksSoal== Assiondang-ondang)"){
            skor += 10
        }
        if(addKataUlang[5].toString() == "Soal(kodeSoal=L31N6, teksSoal== Akbaluk-baluk)"){
            skor += 10
        }
        if(addKataUlang[6].toString() == "Soal(kodeSoal=L31N7, teksSoal== Attinro-tinro)"){
            skor += 10
        }
        if(addKataUlang[7].toString() == "Soal(kodeSoal=L31N8, teksSoal== Assare-sare)"){
            skor += 10
        }
        if(addKataUlang[8].toString() == "Soal(kodeSoal=L31N9, teksSoal== Ammaca-maca)"){
            skor += 10
        }
        if(addKataUlang[9].toString() == "Soal(kodeSoal=L31N10, teksSoal== Appallu-pallu)"){
            skor += 10
        }
    }

    private fun cekJawaban(){

        if(addKataUlang[0].toString() == "Soal(kodeSoal=L31N1, teksSoal== Akballak-ballak)"){
            binding.tva1.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva1.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[1].toString() == "Soal(kodeSoal=L31N2, teksSoal== Akkelong-kelong)"){
            binding.tva2.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva2.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[2].toString() == "Soal(kodeSoal=L31N3, teksSoal== Akkarek-karena)"){
            binding.tva3.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva3.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[3].toString() == "Soal(kodeSoal=L31N4, teksSoal== Akballe-balle)"){
            binding.tva4.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva4.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[4].toString() == "Soal(kodeSoal=L31N5, teksSoal== Assiondang-ondang)"){
            binding.tva5.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva5.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[5].toString() == "Soal(kodeSoal=L31N6, teksSoal== Akbaluk-baluk)"){
            binding.tva6.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva6.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[6].toString() == "Soal(kodeSoal=L31N7, teksSoal== Attinro-tinro)"){
            binding.tva7.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva7.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[7].toString() == "Soal(kodeSoal=L31N8, teksSoal== Assare-sare)"){
            binding.tva8.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva8.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[8].toString() == "Soal(kodeSoal=L31N9, teksSoal== Ammaca-maca)"){
            binding.tva9.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva9.setBackgroundColor(Color.WHITE)
        }
        if(addKataUlang[9].toString() == "Soal(kodeSoal=L31N10, teksSoal== Appallu-pallu)"){
            binding.tva10.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva10.setBackgroundColor(Color.WHITE)
        }
    }

    private fun addRow(soal: Soal) {
        KalimatSoal(this).run row@{
            initRow(soal)
            binding.dragLinearLayout2.run {
                addView(this@row)
                setViewDraggable(this@row, this@row)
            }
        }
    }


    private fun swapElements(startPosition: Int, endPosition: Int) {
        addKataUlang.run {
            this[startPosition] = this[endPosition].also {
                this[endPosition] = this[startPosition]
            }
        }
    }

    companion object {

        private val addKataUlang = mutableListOf(
            Soal("L31N7","= Attinro-tinro"),
            Soal("L31N1","= Akballak-ballak"),
            Soal("L31N9","= Ammaca-maca"),
            Soal("L31N2","= Akkelong-kelong"),
            Soal("L31N5","= Assiondang-ondang"),
            Soal("L31N6","= Akbaluk-baluk"),
            Soal("L31N3","= Akkarek-karena"),
            Soal("L31N4","= Akballe-balle"),
            Soal("L31N8","= Assare-sare"),
            Soal("L31N10","= Appallu-pallu")
        )
        
        var skor = 0
//        var skorAwal = 0
//        var skorAkhir = 0

        var ctvl1 = 0
        var ctvl2 = 0
        var ctvl3 = 0
        var ctvl4 = 0
        var ctvl5 = 0
        var ctvl6 = 0
        var ctvl7 = 0
        var ctvl8 = 0
        var ctvl9 = 0
        var ctvl10 = 0
        var ctvl11 = 0
        var ctvl12 = 0
        var ctvl13 = 0
        var ctvl14 = 0
        var ctvl15 = 0

        var ctva1 = 0
        var ctva2 = 0
        var ctva3 = 0
        var ctva4 = 0
        var ctva5 = 0
        var ctva6 = 0
        var ctva7 = 0
        var ctva8 = 0
        var ctva9 = 0
        var ctva10 = 0
        var ctva11 = 0
        var ctva12 = 0
        var ctva13 = 0
        var ctva14 = 0
        var ctva15 = 0
    }
}