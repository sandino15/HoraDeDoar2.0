package com.example.horadedoar20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.horadedoar20.Menu.Menu
import com.example.horadedoar20.Paginas.PagePrincipal

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, PagePrincipal::class.java)
            startActivity(intent)
        },3000)
    }
}