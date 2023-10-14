package com.example.utspapbmuhammadfadhillah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utspapbmuhammadfadhillah.databinding.ActivityDetail1Binding
import com.example.utspapbmuhammadfadhillah.databinding.ActivityMainBinding
import com.example.utspapbmuhammadfadhillah.databinding.ActivityPaymentMethodBinding

class DetailActivity1 : AppCompatActivity() {
    // membuat binding
    private lateinit var binding: ActivityDetail1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent
        val rating = dataIntent.getStringExtra("EXT_RATING")
        val movieTitle = dataIntent.getStringExtra("EXT_MOVIE")

        with(binding){
            tvRating.text = rating
            movieTitleDetails.text = movieTitle

            // onclick listener btn getticket
            btnGetTicket.setOnClickListener(){
                // intent ke dalam activitypayment
                val intentToPaymentMethodActivity = Intent(this@DetailActivity1, PaymentMethodActivity::class.java)
                intentToPaymentMethodActivity.type = "image/*" // Set the type of data to image
                intentToPaymentMethodActivity.putExtra("EXT_IMAGE", R.drawable.details1)
                // menambahkan titipan pada intentToMainActivity
                intentToPaymentMethodActivity.putExtra("EXT_MOVIETITLE", movieTitle)
                startActivity(intentToPaymentMethodActivity)
            }
        }
    }
}