package com.badrun.examp259

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.zxing.integration.android.IntentIntegrator

class ScanActivity : AppCompatActivity() {

    private lateinit var vieww : TextView
    private lateinit var messa : TextView
    private lateinit var button : Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan)

        supportActionBar?.hide()

        button = findViewById(R.id.scanBtn)

        button.setOnClickListener {
           val intentt = IntentIntegrator(this)
            intentt.setPrompt("Scan a Barcode")
            intentt.setOrientationLocked(true)
            intentt.initiateScan()
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        val iR = IntentIntegrator.parseActivityResult(requestCode,resultCode,data)

        if (iR != null)
        {
            if (iR.contents == null){
                Toast.makeText(this, "Masukan QR Code", Toast.LENGTH_SHORT).show()
            } else {
                val inten = Intent(Intent(this,ViewActivity::class.java))
                inten.apply {
                    putExtra("link",iR.contents.toString())
                }
                startActivity(inten)
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

}