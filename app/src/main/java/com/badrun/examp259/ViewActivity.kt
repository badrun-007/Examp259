package com.badrun.examp259

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class ViewActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        supportActionBar?.hide()

        val url = intent.getStringExtra("link")

        webView = findViewById(R.id.wv)
        webView.webViewClient = WebViewClient()
        if (url != null) {
            webView.loadUrl(url)
        }

        //mengaktifkan websetting
        val webSetting = webView.settings

        //javascript
        webSetting.javaScriptEnabled = true
        webSetting.domStorageEnabled = true

        //Disabled SS
        window.setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE)

    }

    //Disabled tombol kembali
    override fun onBackPressed() {

    }

    override fun onUserLeaveHint() {
        Toast.makeText(this, "Jangan Keluar !", Toast.LENGTH_SHORT).show()
        var i = Intent(this,MainActivity::class.java)
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(i)
        finish()
    }

    private fun per(){
        if(Build.VERSION.SDK_INT >= 19){
            webView.settings.cacheMode = WebSettings.LOAD_NO_CACHE
        }
    }
}