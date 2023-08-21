package com.example.AplBhsDaerah.home.sub.bab6

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.AplBhsDaerah.R
import com.example.AplBhsDaerah.databinding.ActivityMenyimak6Binding
import com.example.AplBhsDaerah.home.sub.SubBab5Activity
import com.example.AplBhsDaerah.home.sub.SubBab6Activity
import com.example.AplBhsDaerah.home.sub.bab4.Menyimak4Activity
import com.example.AplBhsDaerah.home.sub.bab5.Membaca5Activity
import com.geco.zhyskaapp.data.BarisSoal
import com.geco.zhyskaapp.data.Soal
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase


class Menyimak6Activity : AppCompatActivity() {

    private lateinit var binding: ActivityMenyimak6Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenyimak6Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {

            btnCekJawabanKosaMenyimak6.setOnClickListener {
                cekJawaban()
            }

            btnMeyimak6Selesai.setOnClickListener {
                val jawaban1a = inputJawabanMeyimak6no1a.text.toString()
                val jawaban1b = inputJawabanMeyimak6no1b.text.toString()
                val jawaban1c = inputJawabanMeyimak6no1c.text.toString()
                val jawaban2 = inputJawabanMeyimak6no2.text.toString()
                val jawaban3 = inputJawabanMeyimak6no3.text.toString()

                val getUserEmail = Firebase.auth.currentUser?.email.toString()
                cekSkor()

                val pref = applicationContext.getSharedPreferences("Skor", MODE_PRIVATE)
                val editor = pref.edit()

                val skorAkhir = skor
                val activityStatus = "done"

                val skorMenyimak6 = pref.getInt("menyimak6", 0)

                if(skorMenyimak6 == 0){
                    editor.putInt("menyimak6", skorAkhir)
                    editor.apply()
                    Toast.makeText(this@Menyimak6Activity, "Skor yang di dapatkan +${skorAkhir}", Toast.LENGTH_SHORT).show()
                }
                skor = 0

                if (getUserEmail != null) {
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menyimak1a")
                        .setValue(jawaban1a)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menyimak1b")
                        .setValue(jawaban1b)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menyimak1c")
                        .setValue(jawaban1c)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menyimak2")
                        .setValue(jawaban2)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("jawabanbab6").child("menyimak3")
                        .setValue(jawaban3)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("skor").child("menyimak6").setValue(skorAkhir)
                    myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("BagianYangTelahSelesai").child("menyimak6").setValue(activityStatus)
                }


                val intent = Intent(this@Menyimak6Activity, SubBab6Activity::class.java)
                startActivity(intent)
            }

            dragLinearKosamenyimak6.apply {
                setContainerScrollView(scrollKosamenyimak6)
                setOnViewSwapListener { _, startPosition, _, endPosition ->
                    swapElements(startPosition, endPosition)
                }
            }
            addKosakata.forEach {
                addRow(it)
            }
        }
    }

    private fun addRow(soal: Soal) {
        BarisSoal(this).run row@{
            initRow(soal)
            binding.dragLinearKosamenyimak6.run {
                addView(this@row)
                setViewDraggable(this@row, this@row)
            }
        }
    }
    private fun swapElements(startPosition: Int, endPosition: Int) {
        addKosakata.run {
            this[startPosition] = this[endPosition].also {
                this[endPosition] = this[startPosition]
            }
        }
    }
    
    private fun cekSkor(){
        if(addKosakata[0].toString() == "Soal(kodeSoal=kosamenyimak6_1, teksSoal=kerdil)"){
            skor += 10
        }
        if(addKosakata[1].toString() == "Soal(kodeSoal=kosamenyimak6_2, teksSoal=digelar)"){
            skor += 10
        }
        if(addKosakata[2].toString() == "Soal(kodeSoal=kosamenyimak6_3, teksSoal=bertemu)"){
            skor += 10
        }
        if(addKosakata[3].toString() == "Soal(kodeSoal=kosamenyimak6_4, teksSoal=sombong, angkuh)"){
            skor += 10
        }
        if(addKosakata[4].toString() == "Soal(kodeSoal=kosamenyimak6_5, teksSoal=suka mencelah)"){
            skor += 10
        }
        if(addKosakata[5].toString() == "Soal(kodeSoal=kosamenyimak6_6, teksSoal=mendengarkan)"){
            skor += 10
        }
        if(addKosakata[6].toString() == "Soal(kodeSoal=kosamenyimak6_7, teksSoal=menjawab)"){
            skor += 10
        }
        if(addKosakata[7].toString() == "Soal(kodeSoal=kosamenyimak6_8, teksSoal=meninju)"){
            skor += 10
        }
        if(addKosakata[8].toString() == "Soal(kodeSoal=kosamenyimak6_9, teksSoal=saling meninju)"){
            skor += 10
        }
        if(addKosakata[9].toString() == "Soal(kodeSoal=kosamenyimak6_10, teksSoal=orang pendiam)"){
            skor += 10
        }
        if(addKosakata[10].toString() == "Soal(kodeSoal=kosamenyimak6_11, teksSoal=rasakan)"){
            skor += 10
        }
        if(addKosakata[11].toString() == "Soal(kodeSoal=kosamenyimak6_12, teksSoal=bagus, baik)"){
            skor += 10
        }
    }

    private fun cekJawaban(){
        if(addKosakata[0].toString() == "Soal(kodeSoal=kosamenyimak6_1, teksSoal=kerdil)"){
            binding.tva1.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva1.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[1].toString() == "Soal(kodeSoal=kosamenyimak6_2, teksSoal=digelar)"){
            binding.tva2.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva2.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[2].toString() == "Soal(kodeSoal=kosamenyimak6_3, teksSoal=bertemu)"){
            binding.tva3.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva3.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[3].toString() == "Soal(kodeSoal=kosamenyimak6_4, teksSoal=sombong, angkuh)"){
            binding.tva4.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva4.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[4].toString() == "Soal(kodeSoal=kosamenyimak6_5, teksSoal=suka mencelah)"){
            binding.tva5.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva5.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[5].toString() == "Soal(kodeSoal=kosamenyimak6_6, teksSoal=mendengarkan)"){
            binding.tva6.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva6.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[6].toString() == "Soal(kodeSoal=kosamenyimak6_7, teksSoal=menjawab)"){
            binding.tva7.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva7.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[7].toString() == "Soal(kodeSoal=kosamenyimak6_8, teksSoal=meninju)"){
            binding.tva8.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva8.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[8].toString() == "Soal(kodeSoal=kosamenyimak6_9, teksSoal=saling meninju)"){
            binding.tva9.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva9.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[9].toString() == "Soal(kodeSoal=kosamenyimak6_10, teksSoal=orang pendiam)"){
            binding.tva10.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva10.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[10].toString() == "Soal(kodeSoal=kosamenyimak6_11, teksSoal=rasakan)"){
            binding.tva11.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva11.setBackgroundColor(Color.WHITE)
        }
        if(addKosakata[11].toString() == "Soal(kodeSoal=kosamenyimak6_12, teksSoal=bagus, baik)"){
            binding.tva12.setBackgroundColor(Color.GREEN)
        }else{
            binding.tva12.setBackgroundColor(Color.WHITE)
        }
    }

    companion object {
        var skor = 0

        private val addKosakata = mutableListOf(
            Soal("kosamenyimak6_3","bertemu"),
            Soal("kosamenyimak6_1","kerdil"),
            Soal("kosamenyimak6_6","mendengarkan"),
            Soal("kosamenyimak6_2","digelar"),
            Soal("kosamenyimak6_10","orang pendiam"),
            Soal("kosamenyimak6_9","saling meninju"),
            Soal("kosamenyimak6_11","rasakan"),
            Soal("kosamenyimak6_5","suka mencelah"),
            Soal("kosamenyimak6_4","sombong, angkuh"),
            Soal("kosamenyimak6_7","menjawab"),
            Soal("kosamenyimak6_8","meninju"),
            Soal("kosamenyimak6_12","bagus, baik")
        )
    }

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }
}