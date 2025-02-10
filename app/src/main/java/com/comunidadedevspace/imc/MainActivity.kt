package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Recuperar os componentes EditText
        // Criar var e associar o componente

        val edtPeso = findViewById<TextInputEditText>(R.id.edt_peso)
        val edtAltura = findViewById<TextInputEditText>(R.id.edt_altura)

        //Recuperar o button
        //Colocar acao no button e recuperar o texto
        val btnCalculate = findViewById<Button>(R.id.btn_calculate)

        btnCalculate.setOnClickListener{


            val pesoStr: String= edtPeso.text.toString()
            val alturaStr: String = edtAltura.text.toString()

            if (pesoStr == "" || alturaStr == ""){
                //Mostrar msg para o usuário Snackbar

                Snackbar
                    .make(
                        edtPeso,
                        "Preeencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val peso = pesoStr.toFloat()
                val altura = alturaStr.toFloat()

                val alturaQ2 = altura * altura
                val resultado = peso / alturaQ2

                println("O seu IMC é: " + resultado)
            }
        }


    }
}