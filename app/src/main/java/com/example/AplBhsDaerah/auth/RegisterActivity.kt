package com.example.AplBhsDaerah.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.AplBhsDaerah.CustomDialog
import com.example.AplBhsDaerah.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {
            btnRegister.setOnClickListener {
                val email = inputEmailRegister.text.toString()
                val pass = inputPasswordRegister.text.toString()
                val confirmPass = inputConfirmPasswordRegister.text.toString()

                CustomDialog.showLoading(this@RegisterActivity)
                if (checkValidation(email, pass, confirmPass)){
                    registerToServer(email, pass)
                }
            }

        }
    }

    private fun registerToServer(email: String, pass: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener{task ->
                CustomDialog.hideLoading()
                if (task.isSuccessful){
                    startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                    finishAffinity()
                }
            }
            .addOnFailureListener{
                CustomDialog.hideLoading()
                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkValidation(email: String, pass: String, confirmPass: String): Boolean {

        if (email.isEmpty()){
            binding.inputEmailRegister.error = "Please field your email"
            binding.inputEmailRegister.requestFocus()
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.inputEmailRegister.error = "Please use valid email"
            binding.inputEmailRegister.requestFocus()
        }else if (pass.isEmpty()){
            binding.inputPasswordRegister.error = "Please field your password"
            binding.inputPasswordRegister.requestFocus()
        }else if (confirmPass.isEmpty()){
            binding.inputConfirmPasswordRegister.error = "Please field your confirm password"
            binding.inputConfirmPasswordRegister.requestFocus()
        }else if (pass != confirmPass){
            binding.inputPasswordRegister.error = "Your pass didnt match"
            binding.inputConfirmPasswordRegister.error = "Your confirm pass didnt match"

            binding.inputPasswordRegister.requestFocus()
            binding.inputConfirmPasswordRegister.requestFocus()
        }else{
            binding.inputPasswordRegister.error = null
            binding.inputConfirmPasswordRegister.error = null
            return true
        }
        CustomDialog.hideLoading()
        return false
    }
}