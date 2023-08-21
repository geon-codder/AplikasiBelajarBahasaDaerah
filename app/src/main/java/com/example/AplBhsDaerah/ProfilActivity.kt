package com.example.AplBhsDaerah

import android.app.Activity
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.AplBhsDaerah.databinding.ActivityProfilBinding
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import org.checkerframework.checker.nullness.qual.NonNull
import java.io.File
import java.io.IOException
import java.util.*


class ProfilActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfilBinding
    private val PICK_IMAGE_REQUEST = 71
    private var filePath: Uri? = null
    private var firebaseStore: FirebaseStorage? = null
    private var storageReference: StorageReference? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val display = supportActionBar
        display?.title = "Data Siswa"
        display?.setDisplayHomeAsUpEnabled(true)

        firebaseStore = FirebaseStorage.getInstance()
        storageReference = FirebaseStorage.getInstance().reference

        getImage()
        setUserData()
        binding.apply {

            btnProfilToComplete.setOnClickListener {
                val intent = Intent(this@ProfilActivity, CompleteBioActivity::class.java)
                startActivity(intent)
            }
            ivProfilSiswa.setOnClickListener {
                launchGallery()
            }
        }
    }

    private fun setUserData(){
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("dataUser")
        val getUserEmail = Firebase.auth.currentUser?.email.toString()
        if (getUserEmail != null) {
            myRef.child("users").child(encodeUserEmail(getUserEmail).toString()).child("biodata").get().addOnSuccessListener {
                if (it.exists()) {
                    Toast.makeText(this@ProfilActivity, "Data Ditemukan", Toast.LENGTH_SHORT)
                        .show()
                    binding.tvNamaSiswa.text = it.child("nama").value.toString()
                    binding.tvNISSiswa.text = it.child("nis").value.toString()
                    binding.tvKelasSiswa.text = it.child("kelas").value.toString()
                    binding.tvAlamatSiswa.text = it.child("alamat").value.toString()
                    binding.tvSekolahSiswa.text = it.child("sekolah").value.toString()
                } else {
                    Toast.makeText(this@ProfilActivity, "Data Belum Ditemukan", Toast.LENGTH_SHORT).show()
                }
            }.addOnFailureListener {
                Log.e("firebase", "Error getting data", it)
            }
        }else{
            Toast.makeText(this@ProfilActivity, "UserID = null", Toast.LENGTH_SHORT).show()
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

    private fun launchGallery() {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK) {
            if(data == null || data.data == null){
                return
            }

            filePath = data.data
            try {
                val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, filePath)
                binding.ivProfilSiswa.setImageBitmap(bitmap)
                uploadImage()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
    private fun uploadImage(){
        if(filePath != null){
            val ref = storageReference?.child("myImages/${FirebaseAuth.getInstance().currentUser?.email}.jpg")
            val uploadTask = ref?.putFile(filePath!!)
            Toast.makeText(this, "Gambar berhasil diupload", Toast.LENGTH_SHORT).show()

        }else{
            Toast.makeText(this, "Please Upload an Image", Toast.LENGTH_SHORT).show()
        }
    }

    fun encodeUserEmail(userEmail: String): String? {
        return userEmail.replace(".", ",")
    }

    private fun getImage() {
        val myRefPhoto =
            FirebaseStorage.getInstance().reference.child("myImages/${FirebaseAuth.getInstance().currentUser?.email}.jpg")

        val localfile = File.createTempFile("tempimage", "jpg")
        myRefPhoto.getFile(localfile).addOnSuccessListener {
            val bitmap = BitmapFactory.decodeFile(localfile.absolutePath)
            binding.ivProfilSiswa.setImageBitmap(bitmap)
        }.addOnFailureListener {
            Toast.makeText(this, "Foto belum ada", Toast.LENGTH_SHORT).show()
        }
    }
}