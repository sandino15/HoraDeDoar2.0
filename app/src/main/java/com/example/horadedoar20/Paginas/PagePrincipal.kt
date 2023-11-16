package com.example.horadedoar20.Paginas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.horadedoar20.Cadastros.AlterarCadastro
import com.example.horadedoar20.R
import com.example.horadedoar20.RedeHospitais.RedesHospital

class PagePrincipal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page_principal)
    }
    fun BotaopedirDoacao(view: View) {
        val intent = Intent(this, PedirDoacao::class.java)
        startActivity(intent)
    }
    fun BotaoMensagens(view: View) {
        val intent = Intent(this, MensagemDoacao::class.java)
        startActivity(intent)
    }
    fun botaoredes (view: android.view.View) {
        val intent = Intent(this, RedesHospital::class.java)
        startActivity(intent)
    }
    fun botaoAlterarCadastro(view: View) {
        val intent = Intent(this, AlterarCadastro::class.java)
        startActivity(intent)
    }
}
