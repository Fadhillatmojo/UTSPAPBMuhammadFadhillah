package com.example.utspapbmuhammadfadhillah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.utspapbmuhammadfadhillah.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){


            btnLogin.setOnClickListener(){
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                if (username.equals("Fadhil") && password.equals("fadhil123")) {
                    val intentToMainActivity = Intent(this@LoginActivity, MainActivity::class.java)
                    // menambahkan titipan pada intentToMainActivity
                    intentToMainActivity.putExtra("EXT_USERNAME", username)
                    startActivity(intentToMainActivity)
                    finish()
                } else {
                    Toast.makeText(this@LoginActivity, "Masukkan Password/username yang benar!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}