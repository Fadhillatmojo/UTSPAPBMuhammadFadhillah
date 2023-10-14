package com.example.utspapbmuhammadfadhillah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.utspapbmuhammadfadhillah.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    // membuat binding
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding){
            // code disini
            layoutSplashScreen.setOnClickListener(){
                    val intentToLoginActivity = Intent(this@SplashScreenActivity, LoginActivity::class.java)
                    startActivity(intentToLoginActivity)
                }
            }

    }
}