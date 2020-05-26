package com.goblintechs.flex_gasolinaouetanol.activities

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.goblintechs.flex_gasolinaouetanol.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : AppCompatActivity() {
    private var backPressedTime: Long = 0
    private var backToast: Toast? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setSupportActionBar(findViewById(R.id.toolbar))

        btCalculate.setOnClickListener {
            calculate()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle presses on the action bar menu items
        when (item.itemId) {
            R.id.action_cars_menu -> {
                val i = Intent(this@MainActivity, CarsActivity::class.java)
                startActivity(i)
                return true
            }
            R.id.action_calc_consumption_menu -> {
                howCalculate()
                return true
            }
            R.id.action_exit_menu -> {
                FirebaseAuth.getInstance().signOut()
                val i = Intent(this@MainActivity, LoginActivity::class.java)
                startActivity(i)
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun calculate() {
        valFields()

        if (etEthanolConsumption.text!!.isNotEmpty() &&
            etEthanolPrice.text.toString().isNotEmpty() &&
            etGasolineConsumption.text!!.isNotEmpty() &&
            etGasolinePrice.text!!.isNotEmpty()) {
            val ethanolConsumption = etEthanolConsumption.text.toString()
            val gasolineConsumption = etGasolineConsumption.text.toString()
            val ethanolPrice = etEthanolPrice.text.toString()
            val gasolinePrice = etGasolinePrice.text.toString()

            calculateBetterPrice(
                ethanolConsumption,
                gasolineConsumption,
                ethanolPrice,
                gasolinePrice
            )
        }
        else {
            tvResult.visibility = View.INVISIBLE
        }
    }

    private fun calculateBetterPrice(
        ethanolConsumption: String,
        gasolineConsumption: String,
        ethanolPrice: String,
        gasolinePrice: String) {
        val consumoLitroAlcool = ethanolConsumption.toDouble()
        val consumoLitroGasolina = gasolineConsumption.toDouble()
        val valorAlcool = ethanolPrice.toDouble()
        val valorGasolina = gasolinePrice.toDouble()

        /*
        1- Divida o desempenho do etanol pelo desempenho da gasolina (se seu carro faz 7,3 km/litro
        com etanol e 10 km/l com gasolina, você deve dividir 7,3 por 10, que é igual a 0,73 ou 73%.
        Pronto, você achou o rendimento do carro com etanol).
        2- Multiplique o rendimento pelo valor da gasolina
        3- Se o resultado da multiplicação for maior que o preço do álcool, abasteça com álcool.
        4- Caso contrário, abasteça com gasolina.
        */

        val efficiency = consumoLitroAlcool / consumoLitroGasolina
        val result = efficiency * valorGasolina

        if (result >= valorAlcool) {
            tvResult.visibility = View.VISIBLE
            tvResult.setText("Abasteça com Álcool!")
        }
        else {
            tvResult.visibility = View.VISIBLE
            tvResult.setText("Abasteça com Gasolina!")
        }
    }

    private fun valFields() {
        if (etEthanolConsumption.text!!.isEmpty()) {
            tlEthanolConsumption.isErrorEnabled = true
            tlEthanolConsumption.error = getString(R.string.ethanol_consum_error)
        }
        else {
            tlEthanolConsumption.isErrorEnabled = false
        }

        if (etEthanolPrice.text.toString().isEmpty()) {
            tlEthanolPrice.isErrorEnabled = true
            tlEthanolPrice.error = getString(R.string.ethanol_price_error)
        }
        else {
            tlEthanolPrice.isErrorEnabled = false
        }

        if (etGasolineConsumption.text!!.isEmpty()) {
            tlGasolineConsumption.isErrorEnabled = true
            tlGasolineConsumption.error = getString(R.string.gasoline_consum_error)
        }
        else {
            tlGasolineConsumption.isErrorEnabled = false
        }

        if (etGasolinePrice.text!!.isEmpty()) {
            tlGasolinePrice.isErrorEnabled = true
            tlGasolinePrice.error = getString(R.string.gasoline_price_error)
        }
        else {
            tlGasolinePrice.isErrorEnabled = false
        }
    }

    private fun howCalculate() {
        val alertDialog = AlertDialog.Builder(this).create()
        alertDialog.setTitle(getString(R.string.how_calc_consumption))
        alertDialog.setMessage(getString(R.string.how_calc_consumption_info))
        alertDialog.setButton(
            Dialog.BUTTON_POSITIVE,
            getString(R.string.text_ok)) { dialogInterface: DialogInterface?, which: Int ->  }
        //alertDialog.setIcon()
        alertDialog.show()
    }

    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            backToast!!.cancel()
            super.onBackPressed()
            return
        }
        else {
            val message = getString(R.string.press_back)
            backToast = Toast.makeText(this, message, Toast.LENGTH_SHORT)
            backToast!!.show()
        }

        backPressedTime = System.currentTimeMillis()

    }
}
