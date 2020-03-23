package com.goblintechs.flex_gasolinaouetanol

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        btCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val duration = Toast.LENGTH_SHORT
        if (etAlcoholConsumption.text.isEmpty()) {
            Toast.makeText(this, R.string.alcohol_consum_error, duration).show()
        }
        else if (etGasolineConsumption.text.isEmpty()) {
            Toast.makeText(this, R.string.gasoline_consum_error, duration).show()
        }
        else if (etAlcoholPrice.text.isEmpty()) {
            Toast.makeText(this, R.string.alcohol_price_error, duration).show()
        }
        else if (etGasolinePrice.text.isEmpty()) {
            Toast.makeText(this, R.string.gasoline_price_error, duration).show()
        }
        else {
            val consumoAlcool = etAlcoholConsumption.text.toString()
            val consumoGasolina = etGasolineConsumption.text.toString()
            val precoAlcool = etAlcoholPrice.text.toString()
            val precoGasolina = etGasolinePrice.text.toString()

            calculateBetterPrice(consumoAlcool, consumoGasolina, precoAlcool, precoGasolina)
        }
    }

    private fun calculateBetterPrice(
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
            tvResult.visibility = View.VISIBLE
            tvResult.setText("Abasteça com Álcool!")
        }
        else {
            tvResult.visibility = View.VISIBLE
            tvResult.setText("Abasteça com Gasolina!")
        }
    }

    private fun exit() {
        AlertDialog.Builder(this).setMessage(R.string.exit_question).setCancelable(false)
            .setPositiveButton(R.string.text_yes) { _, _ -> finish() }
            .setNegativeButton(R.string.text_cancel, null).show()
    }

    override fun onBackPressed() {
        exit()
    }
}
