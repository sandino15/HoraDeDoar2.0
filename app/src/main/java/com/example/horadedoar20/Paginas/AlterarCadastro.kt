package com.example.horadedoar20.Paginas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.horadedoar20.Helper.Base64Custom
import com.example.horadedoar20.Helper.ConfiguracaoFireBase
import com.example.horadedoar20.Menu.Menu
import com.example.horadedoar20.Model.Usuario
import com.example.horadedoar20.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener

class AlterarCadastro : AppCompatActivity() {

    private lateinit var campoNome: EditText
    private lateinit var campoEmail: EditText
    private lateinit var campoFone: EditText
    private lateinit var campoSenha: EditText
    private lateinit var campoConfirmarSenha: EditText
    private lateinit var campoEndereco: EditText
    private lateinit var campoNascimento: EditText
    private lateinit var campoSangue: EditText
    private lateinit var botaoCadastrar: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var Alterar: String
    private lateinit var CadastroAtualizado: String
    private lateinit var usuario: Usuario
    private var autenticacao: FirebaseAuth = ConfiguracaoFireBase().getFirebaseAutenticacao()
    private var referenciaFirebase: DatabaseReference = ConfiguracaoFireBase().getFirebaseDataBase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alterar_cadastro)
        inicializarComponentes()

        // Cadastrar usuário
        progressBar.visibility = View.GONE
        botaoCadastrar.setOnClickListener {
            val textoNome = campoNome.text.toString()
            val textoConfirmarSenha = campoConfirmarSenha.text.toString()
            val textoEmail = campoEmail.text.toString()
            val textoSenha = campoSenha.text.toString()
            val textoFone = campoFone.text.toString()
            val textoEndereco = campoEndereco.text.toString()
            val textoIdade = campoNascimento.text.toString()
            val textoSangue = campoSangue.text.toString()


            if (!textoNome.isEmpty()) {
                if (!textoIdade.isEmpty()) {
                    if (!textoFone.isEmpty()) {
                        if (!textoSangue.isEmpty()) {
                            if (!textoEndereco.isEmpty()) {
                                if (!textoEmail.isEmpty()) {
                                    if (!textoSenha.isEmpty()) {
                                        usuario = Usuario()
                                        usuario.nome = textoNome
                                        usuario.nascimento = textoIdade
                                        usuario.fone = textoFone
                                        usuario.sangue = textoSangue
                                        usuario.email = textoEmail
                                        usuario.endereco = textoEndereco
                                        usuario.senha = textoSenha
                                        usuario.confirmarSenha == textoSenha
                                        MudarCadastrar(usuario)

                                    } else {
                                        Toast.makeText(
                                            this@AlterarCadastro,
                                            "Preencha a senha   !",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                } else {
                                    Toast.makeText(
                                        this@AlterarCadastro,
                                        "Preencha com a email!",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                            } else {
                                Toast.makeText(
                                    this@AlterarCadastro,
                                    "Preencha o seu Endereço!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        } else {
                            Toast.makeText(
                                this@AlterarCadastro,
                                "Preencha o sangue!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    } else {
                        Toast.makeText(
                            this@AlterarCadastro,
                            "Preencha a fone!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                } else {
                    Toast.makeText(
                        this@AlterarCadastro,
                        "Preencha o idade!",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            } else {
                Toast.makeText(
                    this@AlterarCadastro,
                    "Preencha o nome!",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }
    }

    @SuppressLint("SuspiciousIndentation")
    fun MudarCadastrar(usuario: Usuario) {
        val textoSenha = null
        val textoConfirmarSenha = null
        if (textoSenha == textoConfirmarSenha) {
            progressBar.visibility = View.VISIBLE
            autenticacao = ConfiguracaoFireBase().getFirebaseAutenticacao()
            autenticacao.createUserWithEmailAndPassword(usuario.email, usuario.senha)
            val emailUsuario = autenticacao.currentUser?.email
            Log.d("AlterarCadastro", "Email do usuário: $emailUsuario")

            val base64Custom = Base64Custom()
            val idUsuario = base64Custom.codificarBase64(emailUsuario.toString())
            val novoUsuarioRef = referenciaFirebase.child("Usuarios").child(idUsuario)

            val dadosUsuario = mapOf(
                "nome" to usuario.nome,
                "nascimento" to usuario.nascimento,
                "fone" to usuario.fone,
                "sangue" to usuario.sangue,
                "email" to usuario.email,
                "endereco" to usuario.endereco,
                "senha" to usuario.senha,
                "confirmarSenha" to usuario.confirmarSenha
            )
            usuario.salvar()
            novoUsuarioRef.updateChildren(dadosUsuario).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@AlterarCadastro, "Cadastro atualizado com sucesso", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(applicationContext,Menu::class.java))
                    finish()
                } else {
                    progressBar.visibility = View.GONE
                    Toast.makeText(this@AlterarCadastro, "Erro ao atualizar cadastro", Toast.LENGTH_SHORT).show()
                }
            }
        } else {
            Toast.makeText(this@AlterarCadastro, "As senhas não coincidem!", Toast.LENGTH_SHORT).show()
        }
    }


    private fun Usuario(idUsuario: String) {


    }

    private fun inicializarComponentes() {
        campoNome = findViewById(R.id.editCadastroNome)
        campoEmail = findViewById(R.id.editCadastroEmail)
        campoSenha = findViewById(R.id.editCadastroSenha)
        campoConfirmarSenha = findViewById(R.id.ConfirmarSenha)
        campoFone = findViewById(R.id.editCadastroFone)
        campoEndereco = findViewById(R.id.editCadastroEndereco)
        campoNascimento = findViewById(R.id.editCadastroNascimento)
        campoSangue = findViewById(R.id.editCadastroSangue)
        botaoCadastrar = findViewById(R.id.botaoCadastro)
        progressBar = findViewById(R.id.progressCadastro)

        campoNome.requestFocus()


    }
}

