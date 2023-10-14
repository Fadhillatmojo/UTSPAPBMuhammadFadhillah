package com.example.utspapbmuhammadfadhillah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utspapbmuhammadfadhillah.databinding.ActivityDetail2Binding
import com.example.utspapbmuhammadfadhillah.databinding.ActivityDetail3Binding

class DetailActivity3 : AppCompatActivity() {
    // membuat binding
    private lateinit var binding: ActivityDetail3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetail3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent
        val rating = dataIntent.getStringExtra("EXT_RATING")
        val movieTitle = dataIntent.getStringExtra("EXT_MOVIE")

        with(binding){
            tvRating.text = rating
            movieTitleDetails.text = movieTitle

            // image view back button
            imageView.setOnClickListener(){finish()}

            // onclick listener btn getticket
            btnGetTicket.setOnClickListener(){
                // intent ke dalam activitypayment
                val intentToPaymentMethodActivity = Intent(this@DetailActivity3, PaymentMethodActivity::class.java)
                intentToPaymentMethodActivity.type = "image/*" // Set the type of data to image
                intentToPaymentMethodActivity.putExtra("EXT_IMAGE", R.drawable.details2)
                // menambahkan titipan pada intentToMainActivity
                intentToPaymentMethodActivity.putExtra("EXT_MOVIETITLE", movieTitle)
                startActivity(intentToPaymentMethodActivity)
            }
        }
    }
}