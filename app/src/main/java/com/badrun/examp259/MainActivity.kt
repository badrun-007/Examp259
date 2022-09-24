package com.badrun.examp259

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.badrun.examp259.databinding.ActivityMainBinding
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.ScanOptions

class MainActivity : AppCompatActivity() {


    private lateinit var button: Button
    private lateinit var jud: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        jud = findViewById(R.id.judul)
        button = findViewById(R.id.masuk)
        button.setOnClickListener {

            startActivity(Intent(this, ScanActivity::class.java))
//            val iI = IntentIntegrator(this)
//            iI.setPrompt("Scan QR Code")
//            iI.setBeepEnabled(false)
//            iI.setOrientationLocked(false)
//            iI.initiateScan()
        }

    }

}