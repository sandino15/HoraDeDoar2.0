package com.example.horadedoar20.Menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.horadedoar20.Cadastros.Cadastro
import com.example.horadedoar20.Login.Login
import com.example.horadedoar20.R

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
    }
    fun menuCadastro(view: View) {
        val intent = Intent(this, Cadastro::class.java)
        startActivity(intent)
    }

    fun menuLogin(view: View) {
        val intent = Intent(this, Login::class.java)
        startActivity(intent)
    }

}