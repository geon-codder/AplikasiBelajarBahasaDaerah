package com.example.AplBhsDaerah.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.example.AplBhsDaerah.databinding.ActivityResetPasswordBinding
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResetPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResetPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        binding.apply {
            btnResetPassword.setOnClickListener {
                val email = inputEmailResetPassword.text.toString()
                if (email.isEmpty()){
                    inputEmailResetPassword.error = "Please field your email"
                    inputEmailResetPassword.requestFocus()
                    return@setOnClickListener
                }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    inputEmailResetPassword.error = "Please use valid email"
                    inputEmailResetPassword.requestFocus()
                    return@setOnClickListener
                }else{
                    forgotPass(email)
                }
            }
        }
    }
    private fun forgotPass(email: String) {
        FirebaseAuth.getInstance().sendPasswordResetEmail(email)
            .addOnCompleteListener { task ->
                if (task.isSuccessful){
                    Toast.makeText(this, "Your reset password has been sent to your email", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, LoginActivity::class.java))
                    finishAffinity()
                }else{
                    Toast.makeText(this, "Failed reset password", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
            }
    }
}