package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.manajementugas.databinding.ActivitySigninBinding
import com.google.firebase.auth.FirebaseAuth

class login : AppCompatActivity() {
    private lateinit var binding:ActivitySigninBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySigninBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.textView.setOnClickListener{ //agar saat tombol ditekan akan merespon
            val intent = Intent(this, login::class.java)
            startActivity(intent)
        }

        binding.button.setOnClickListener{ //agar saat tombol ditekan akan merespon
            val email = binding.emailEt.text.toString()
            val pass = binding.passET.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty()) {


                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, MainActivity::class.java) //jika login berhasil, akan langsung diarahkan ke menu chat
                        startActivity(intent)

                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show() //jika terjadi error
                    }
                }


            } else {
                Toast.makeText(this, "Jangan kosong ya..", Toast.LENGTH_SHORT).show() // Pemberitahuan toast kalau tempat signup kosong tapi user sudah memencet tombol signup
            }
        }



    }
}