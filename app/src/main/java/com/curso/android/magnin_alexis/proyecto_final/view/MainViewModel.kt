package com.curso.android.magnin_alexis.proyecto_final.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.curso.android.magnin_alexis.proyecto_final.model.Comparador

class MainViewModel: ViewModel() {
    val comparador: LiveData<Comparador> get() = _comparador
    private var _comparador = MutableLiveData<Comparador>(Comparador(null, null, null))

    fun compararTextos(texto1: String?, texto2: String?){
        var resultado: Boolean? = null
        if (texto1 != null && texto2 != null) resultado = texto1 == texto2
        _comparador.value = Comparador(texto1, texto2, resultado)
    }
}