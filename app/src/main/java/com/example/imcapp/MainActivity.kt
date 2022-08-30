package com.example.imcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.main_constraint.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_constraint)
    }

    fun calcular(view: View){

        val peso = editTextPesoConstraint.text.toString()
        val altura = editTextAlturaConstraint.text.toString()

        val validaCampos = validarCampos(peso, altura)

        if (validaCampos){
            calcularIMC(peso, altura)
        } else{
            textViewTitleConstraint.text = "Preencha os Campos Abaixo Primeiro!!!"
        }
    }

    private fun validarCampos(peso: String, altura: String): Boolean{

        var camposValidados: Boolean = true

        if(peso == null || peso.equals("")){
            camposValidados = false
        } else if( altura == null || altura.equals("")){
            camposValidados = false
        }

        return camposValidados
    }

    private  fun calcularIMC(peso: String, altura: String){

        val valorPeso = peso.toDouble()
        val valorAltura = altura.toDouble()

        val imc = valorPeso / (valorAltura * valorAltura)
        textViewTitleConstraint.text = "Seu IMC é: $imc"

    }

}
