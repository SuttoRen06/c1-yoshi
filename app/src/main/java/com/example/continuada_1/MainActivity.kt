package com.example.continuada_1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.math.RoundingMode
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun calcular(view:View)
    {
        val nome = et_nome.text
        val nota1 = et_text.text.toString().toDouble()
        val nota2 = et_text2.text.toString().toDouble()
        val nota3 = et_text3.text.toString().toDouble()
        val media = (nota1 + nota2 + nota3 ) / 3
        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING
        var validacao = 0


        if (nota1 in 0.0..10.0)
        {
            validacao += 1
        }
        if (nota2 in 0.0..10.0)
        {
            validacao +=  1
        }
        if (nota3 in 0.0..10.0)
        {
            validacao +=  1
        }
        if (tx_nome.length() != 0)
        {
            validacao +=  1
        }

        if (validacao == 4) {
            if (media > 0 && media < 5) {
                tx_msg.text =
                    "Infelizmente ${nome} você ficou abaixo da média meu filho, sua média é ${df.format(media)}"
                tx_msg.setTextColor(Color.RED)
            } else if (media >= 5 && media <= 10) {
                tx_msg.text =
                    "Felizmente ${nome} você ficou acima da média meu filho, super estágiario de sucesso, sua média é ${df.format(media)}"
                tx_msg.setTextColor(Color.GREEN)
            }
        }
        else{
            Toast.makeText(this,"Nome ou nota invalido", Toast.LENGTH_SHORT).show()
            tx_msg.text = ""
        }


    }

}