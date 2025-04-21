package com.example.inputcontroldate

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val picker = findViewById<DatePicker>(R.id.datePicker)

        val today = Calendar.getInstance()
        picker.init(
            today.get(Calendar.YEAR),
            today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)
        ) { view, year, month, day ->
            val month = month + 1

            //AlertDialog
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Konfirmasi Tanggal")
            builder.setMessage("$day/$month/$year")
            builder.setPositiveButton("OK") { _, _ ->

                //Toast
                Toast.makeText(
                    this,
                    "Tanggal telah dikonfirmasi: $day/$month/$year",
                    Toast.LENGTH_SHORT
                ).show()
            }
            builder.setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            builder.show()
        }


    }
}
