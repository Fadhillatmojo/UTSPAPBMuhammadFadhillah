package com.example.utspapbmuhammadfadhillah

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utspapbmuhammadfadhillah.databinding.ActivityMainBinding
import com.example.utspapbmuhammadfadhillah.databinding.ActivityOrderBinding
import java.text.SimpleDateFormat
import java.util.*

class OrderActivity : AppCompatActivity() {
    // membuat binding
    private lateinit var binding: ActivityOrderBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dataIntent = intent
        val imageData = dataIntent.getIntExtra("EXT_IMAGE", 1)
        val movieTitle = dataIntent.getStringExtra("EXT_MOVIETITLE")
        val cinema = dataIntent.getStringExtra("EXT_CINEMA")
        val seatType = dataIntent.getStringExtra("EXT_SEATTYPE")
        val date = dataIntent.getStringExtra("EXT_DATE")
        val time = dataIntent.getStringExtra("EXT_TIME")
        val amount = dataIntent.getIntExtra("EXT_AMOUNT", 1)
        val price = dataIntent.getIntExtra("EXT_PRICE", 35000)
        val paymentMethod = dataIntent.getStringExtra("EXT_PAYMENTMETHOD")

        with(binding){
            // image view back button
            imageView.setOnClickListener(){finish()}

            imageviewOrder.setImageResource(imageData)

            orderTitle.text = movieTitle

            tvCinema.text = cinema

            tvSeatTypeOrder.text = seatType

            tvTime.text = "$date, $time"

            var seatTypeShown = "$seatType Seat"
            tvSeatTypeOrder2.text = seatTypeShown

            var priceShown = "Rp$price,00"
            tvPriceOrder.text = priceShown

            var amountShown = "$amount"
            tvAmountOrder.text = amountShown

            tvPaymentMethodOrder.text = paymentMethod

            var actualPay = amount*price
            tvActualPay.text = "Rp$actualPay,00"

        }
    }
}