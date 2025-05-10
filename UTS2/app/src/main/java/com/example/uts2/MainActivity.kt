package com.example.uts2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

            supportActionBar?.hide() //berfungsi untuk menyembunyikan support bar agar yang tampil hanya splash screen saja

        Handler().postDelayed({
            val intent = Intent(this@MainActivity, SigninActivity::class.java) //agar setelah animasi splash screen selesai akan langsung dialihkan ke menu login
            startActivity(intent)
            finish()
        }, 3000) //waktu delay spalsh screen (3 detik)

    }
}
