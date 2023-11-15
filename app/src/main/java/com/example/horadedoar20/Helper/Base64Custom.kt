package com.example.horadedoar20.Helper

import java.util.Base64

class Base64Custom {

    fun codificarBase64(texto: String): String {
        val bytes = texto.toByteArray(Charsets.UTF_8)
        return android.util.Base64.encodeToString(bytes, android.util.Base64.NO_WRAP)
    }


    fun decodificarBase64(textoCodificado: String): String {
        val bytesDecodificados = android.util.Base64.decode(textoCodificado, android.util.Base64.DEFAULT)
        return String(bytesDecodificados)
    }
}
