package com.example.utspapbmuhammadfadhillah

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.utspapbmuhammadfadhillah.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    // membuat binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val dataIntent = intent

        val username = dataIntent.getStringExtra("EXT_USERNAME")


        with(binding){
            // code disini
            // ini utk mengubah username
            tvYourname.text = username

            // ini onclick setiap filmnya
            movie1.setOnClickListener(){
                val rating = "3.0"
                val intentToDetailActivity2 = Intent(this@MainActivity, DetailActivity2::class.java)
                // menambahkan titipan pada intentToDetailActivity2
                intentToDetailActivity2.putExtra("EXT_RATING", rating)
                intentToDetailActivity2.putExtra("EXT_MOVIE", danur.text.toString())
                startActivity(intentToDetailActivity2)
            }
            movie2.setOnClickListener(){
                val rating = "4.5"
                val intentToDetailActivity3 = Intent(this@MainActivity, DetailActivity3::class.java)
                // menambahkan titipan pada intentToDetailActivity3
                intentToDetailActivity3.putExtra("EXT_RATING", rating)
                intentToDetailActivity3.putExtra("EXT_MOVIE", mencurisaleh.text.toString())
                startActivity(intentToDetailActivity3)
            }
            movie3.setOnClickListener(){
                val rating = "4.0"
                val intentToDetailActivity4 = Intent(this@MainActivity, DetailActivity4::class.java)
                // menambahkan titipan pada intentToDetailActivity4
                intentToDetailActivity4.putExtra("EXT_RATING", rating)
                intentToDetailActivity4.putExtra("EXT_MOVIE", thenun2.text.toString())
                startActivity(intentToDetailActivity4)
            }
            movie4.setOnClickListener(){
                val rating = "4.0"
                val intentToDetailActivity1 = Intent(this@MainActivity, DetailActivity1::class.java)
                // menambahkan titipan pada intentToDetailActivity1
                intentToDetailActivity1.putExtra("EXT_RATING", rating)
                intentToDetailActivity1.putExtra("EXT_MOVIE", eyes.text.toString())
                startActivity(intentToDetailActivity1)
            }
            movie5.setOnClickListener(){
                val rating = "4.0"
                val intentToDetailActivity5 = Intent(this@MainActivity, DetailActivity5::class.java)
                // menambahkan titipan pada intentToDetailActivity5
                intentToDetailActivity5.putExtra("EXT_RATING", rating)
                intentToDetailActivity5.putExtra("EXT_MOVIE", ratu.text.toString())
                startActivity(intentToDetailActivity5)
            }
            movie6.setOnClickListener(){
                val rating = "4.6"
                val intentToDetailActivity6 = Intent(this@MainActivity, DetailActivity6::class.java)
                // menambahkan titipan pada intentToDetailActivity6
                intentToDetailActivity6.putExtra("EXT_RATING", rating)
                intentToDetailActivity6.putExtra("EXT_MOVIE", rafathar.text.toString())
                startActivity(intentToDetailActivity6)
            }
        }
    }
}