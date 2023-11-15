package com.example.horadedoar20.Helper

import com.example.horadedoar20.Model.Usuario
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ConfiguracaoFireBase {
    private var referenciaFirebase: DatabaseReference? =null
    private var referenciaAutenticacao: FirebaseAuth? = null

    fun getFirebaseDataBase(): DatabaseReference {
        // Não é necessário inicializar novamente, pois já foi inicializado no construtor
        if(referenciaFirebase == null){
            referenciaFirebase = FirebaseDatabase.getInstance().reference
        }
        return referenciaFirebase !!
    }

    // Retorna a instância do FirebaseAuth
    fun getFirebaseAutenticacao(): FirebaseAuth {
        if (referenciaAutenticacao == null) {
            referenciaAutenticacao = FirebaseAuth.getInstance()
        }
        return referenciaAutenticacao!!
    }

    fun salvarUsuario(usuario: Usuario) {
        val referenciaFirebase = getFirebaseDataBase()
        val novoUsuarioRef = referenciaFirebase.child("Usuarios").push() // Gera um novo ID único
        usuario.id = novoUsuarioRef.key.toString()
        novoUsuarioRef.setValue(usuario)
    }
}
