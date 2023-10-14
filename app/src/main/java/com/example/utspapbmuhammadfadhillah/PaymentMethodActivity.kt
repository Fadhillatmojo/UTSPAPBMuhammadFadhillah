package com.example.utspapbmuhammadfadhillah

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.DatePicker
import com.example.utspapbmuhammadfadhillah.databinding.ActivityOrderBinding
import com.example.utspapbmuhammadfadhillah.databinding.ActivityPaymentMethodBinding
import java.text.SimpleDateFormat
import java.util.*

class PaymentMethodActivity : AppCompatActivity() {
    // membuat binding
    private lateinit var binding: ActivityPaymentMethodBinding
    // inisiasi awal variable variable
    private lateinit var cinemas: Array<String>
    private lateinit var seatTypes: Array<String>
    private lateinit var paymentMethods: Array<String>

    // ini variable untuk date
    private var year: Int = 0
    private var month: Int = 0
    private var day: Int = 0
    // ini variable untuk time
    private var hour: Int = 0
    private var minute: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaymentMethodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        cinemas = resources.getStringArray(R.array.cinemas)
        seatTypes = resources.getStringArray(R.array.seat_type)
        paymentMethods = resources.getStringArray(R.array.payment_methods)

        // mengambil data intent
        val dataIntent = intent
        val imageData = dataIntent.getIntExtra("EXT_IMAGE", 1)
        val movieTitle = dataIntent.getStringExtra("EXT_MOVIETITLE")

        // default value selected
        var selectedCinema ="Ambarukmo XXI Yogyakarta"
        var selectedSeatType ="Regular"
        var selectedPrice = 35000
        var selectedPaymentMethod ="Bank Transfer BNI"
        var amountTicket = 1

        with(binding){
            // image view back button
            imageView.setOnClickListener(){finish()}

            // spinner adapter cinema
            val adapterCinemas = ArrayAdapter(this@PaymentMethodActivity, android.R.layout.simple_spinner_item, cinemas)

            adapterCinemas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerCinema.adapter = adapterCinemas

            // get data from spinner cinema
            spinnerCinema.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                    selectedCinema = cinemas[position]
                }
                // Handle jika tidak ada item yang dipilih (opsional)
                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    selectedCinema = cinemas[0]
                }
            })
            // end spinner adapter cinema

            // start spinner adapter seat type
            val adapterSeatTypes = ArrayAdapter(this@PaymentMethodActivity, android.R.layout.simple_spinner_item, seatTypes)

            adapterSeatTypes.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerSeatType.adapter = adapterSeatTypes

            // get data from spinner seat type
            spinnerSeatType.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                    selectedSeatType = seatTypes[position]
                    //ini mengubah tv seat type
                    tvSeatType.text = seatTypes[position]

                    // ini logic untuk pricenya
                    if (position == 0) {
                        selectedPrice = 35000
                    } else if(position == 1){
                        selectedPrice = 40000
                    } else if(position == 2){
                        selectedPrice = 50000
                    }
                    var tvPriceShown = "Rp$selectedPrice,00"
                    tvPrice.text = tvPriceShown
                    var total = selectedPrice*amountTicket
                    var totalShown = "Rp$total,00"
                    tvPriceTotalView.text = totalShown
                }
                // Handle jika tidak ada item yang dipilih (opsional)
                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    selectedSeatType = seatTypes[0]
                    var total = selectedPrice*amountTicket
                    var totalShown = "Rp$total,00"
                    tvPriceTotalView.text = totalShown
                }
            })
            // end spinner adapter seat type

            // button choose date
            btnDateshow.setOnClickListener(){
                showDatePickerDialog()
            }
            // end button choose date

            // textview choose time
            tvTime.setOnClickListener(){
                showTimePickerDialog()
            }
            // end text view choose time

            // start amount ticket
            tvMinus.setOnClickListener(){
                amountTicket--
                tvDisplayAmount.text = "$amountTicket"
                var total = selectedPrice*amountTicket
                var totalShown = "Rp$total,00"
                tvPriceTotalView.text = totalShown
            }
            tvAdd.setOnClickListener(){
                amountTicket++
                tvDisplayAmount.text = "$amountTicket"
                var total = selectedPrice*amountTicket
                var totalShown = "Rp$total,00"
                tvPriceTotalView.text = totalShown
            }
            // end amount ticket

            // spinner adapterPaymentMethod
            val adapterPaymentMethod = ArrayAdapter(this@PaymentMethodActivity, android.R.layout.simple_spinner_item, paymentMethods)

            adapterPaymentMethod.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPaymentMethod.adapter = adapterPaymentMethod

            // get data from spinner cinema
            spinnerPaymentMethod.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parentView: AdapterView<*>?, selectedItemView: View?, position: Int, id: Long) {
                    selectedPaymentMethod = paymentMethods[position]
                }
                // Handle jika tidak ada item yang dipilih (opsional)
                override fun onNothingSelected(parentView: AdapterView<*>?) {
                    selectedPaymentMethod = paymentMethods[0]
                }
            })
            // end spinner adapter paymentMethods





            // button order summary
            btnOrderSummary.setOnClickListener(){
                val intentToOrderActivity = Intent(this@PaymentMethodActivity, OrderActivity::class.java)
                // menambahkan titipan pada intentToOrderActivity
                intentToOrderActivity.putExtra("EXT_IMAGE", imageData)
                intentToOrderActivity.putExtra("EXT_CINEMA", selectedCinema)
                intentToOrderActivity.putExtra("EXT_SEATTYPE", selectedSeatType)
                intentToOrderActivity.putExtra("EXT_PRICE", selectedPrice)
                intentToOrderActivity.putExtra("EXT_DATE", tvSelectedDate.text.toString())
                intentToOrderActivity.putExtra("EXT_TIME", tvTime.text.toString())
                intentToOrderActivity.putExtra("EXT_AMOUNT", amountTicket)
                intentToOrderActivity.putExtra("EXT_PAYMENTMETHOD", selectedPaymentMethod)
                intentToOrderActivity.putExtra("EXT_MOVIETITLE", movieTitle)
                startActivity(intentToOrderActivity)
            }
        }
    }

    // ini membuat suatu variable untuk date listener jadi ketika tanggalnya di klik, maka akan menginisiasikan variable year month dan day
    private val dateSetListener = DatePickerDialog.OnDateSetListener { _, selectedYear, selectedMonth, selectedDay ->
        year = selectedYear
        month = selectedMonth
        day = selectedDay
        val selectedDate = "Date: $day/$month/$year"
        // Update selected date text view
        with(binding){
            tvSelectedDate.text = selectedDate
        }

    }

    //ini fungsi show datepickerdialog
    fun showDatePickerDialog() {
        val datePickerDialog = DatePickerDialog(this, dateSetListener, year, month, day)
        datePickerDialog.show()
    }

    // ini membuat suatu variable untuk date listener jadi ketika waktunya di klik, maka akan menginisiasikan variable hour dan minute
    private val timeSetListener = TimePickerDialog.OnTimeSetListener { _, selectedHour, selectedMinute ->
        hour = selectedHour
        minute = selectedMinute
        val selectedTime = "$hour:$minute"
        // Update selected time text view
        with(binding){
            tvTime.text = selectedTime
        }
    }

    // ini fungsi show timepickerdialog
    fun showTimePickerDialog() {
        val timePickerDialog = TimePickerDialog(this, timeSetListener, hour, minute, true)
        timePickerDialog.show()
    }




}