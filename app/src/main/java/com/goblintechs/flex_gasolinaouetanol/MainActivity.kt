package com.goblintechs.flex_gasolinaouetanol

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        btCalculate.setOnClickListener {
            calcular()
        }
    }

    fun calcular() {
        val consumoAlcool = etAlcoholConsumption.text.toString()
        val consumoGasolina = etGasolineConsumption.text.toString()
        val precoAlcool = etAlcoholPrice.text.toString()
        val precoGasolina = etGasolinePrice.text.toString()

        calcularMelhorPreco(consumoAlcool, consumoGasolina, precoAlcool, precoGasolina)
    }

    fun calcularMelhorPreco(
        consumoAlcool: String,
        consumoGasolina: String,
        precoAlcool: String,
        precoGasolina: String) {
        val consumoLitroAlcool = consumoAlcool.toDouble()
        val consumoLitroGasolina = consumoGasolina.toDouble()
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        /*
        1- Divida o desempenho do etanol pelo desempenho da gasolina (se seu carro faz 7,3 km/litro
        com etanol e 10 km/l com gasolina, você deve dividir 7,3 por 10, que é igual a 0,73 ou 73%.
        Pronto, você achou o rendimento do carro com etanol).
        2- Multiplique o rendimento pelo valor da gasolina
        3- Se o resultado da multiplicação for maior que o preço do álcool, abasteça com álcool.
        4- Caso contrário, abasteça com gasolina.
        */

        val rendimento = consumoLitroAlcool / consumoLitroGasolina
        val resultado = rendimento * valorGasolina

        if (resultado >= valorAlcool) {
            tvResult.setText("Abasteça com Álcool!")
        }
        else {
            tvResult.setText("Abasteça com Gasolina!")
        }
    }
}
