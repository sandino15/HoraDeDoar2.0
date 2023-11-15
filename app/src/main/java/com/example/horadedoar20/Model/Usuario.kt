package com.example.horadedoar20.Model


import com.example.horadedoar20.Helper.ConfiguracaoFireBase
import com.google.firebase.database.DatabaseReference

class Usuario (
    var id: String,
    var nome: String,
    var email: String,
    var senha: String,
    var fone: String,
    var endereco: String,
    var nascimento: String,
    var sangue: String,
    var confirmarSenha: String,
) {
    constructor() : this("", "", "", "", "", "", "", "","")
    fun salvar(){
        val firebaseRef: DatabaseReference = ConfiguracaoFireBase().getFirebaseDataBase()
        val usuariosRf : DatabaseReference = firebaseRef.child("usuarios")
            .child(id)
        usuariosRf.setValue(this)
    }

    fun id(idUsuario: String) {

    }

}