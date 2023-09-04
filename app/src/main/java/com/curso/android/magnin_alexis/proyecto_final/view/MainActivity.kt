package com.curso.android.magnin_alexis.proyecto_final.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.curso.android.magnin_alexis.proyecto_final.R
import com.curso.android.magnin_alexis.proyecto_final.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.labelResultado.text = ""
        setContentView(binding.root)

        mainViewModel.comparador.observe(this){
            if (it.resultado != null) {
                println("Nueva comparación entre '${it.texto1}' y '${it.texto2}'")
                var idResultado: Int = if (it.resultado) R.string.resultado_true else R.string.resultado_false
                binding.labelResultado.text = getString(idResultado)
            }
        }

        binding.btComparar.setOnClickListener{
            val texto1: String = binding.editTexto1.text.toString()
            val texto2: String = binding.editTexto2.text.toString()
            if(texto1 != "" && texto2 != "") mainViewModel.compararTextos(texto1, texto2)
            else binding.labelResultado.text = getString(R.string.resultado_error)
        }

    }

}