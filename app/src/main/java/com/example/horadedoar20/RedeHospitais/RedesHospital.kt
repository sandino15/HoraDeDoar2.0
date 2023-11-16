package com.example.horadedoar20.RedeHospitais

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.horadedoar20.Maps.MapsActivity
import com.example.horadedoar20.Maps.MapsIhene
import com.example.horadedoar20.R

class RedesHospital : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redes_hospital)
    }


    fun HemopeClick (view: android.view.View) {
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }
    fun IheneClick (view: android.view.View) {
        val intent = Intent(this, MapsIhene::class.java)
        startActivity(intent)
    }
}