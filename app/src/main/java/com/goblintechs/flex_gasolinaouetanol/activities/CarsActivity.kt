package com.goblintechs.flex_gasolinaouetanol.activities

import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.goblintechs.flex_gasolinaouetanol.R
import com.goblintechs.flex_gasolinaouetanol.adapters.ListCarAdapter
import com.goblintechs.flex_gasolinaouetanol.classes.ExampleItem
import kotlinx.android.synthetic.main.cars_activity.*
import kotlinx.android.synthetic.main.dialog_car.view.*

class CarsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cars_activity)

        val carsList = generateList()
        recycler.adapter = ListCarAdapter(carsList)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)

        btAddCar.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.dialog_car, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle(R.string.add_car)
            val mAlertDialog = mBuilder.show()
            mDialogView.btCarCancel.setOnClickListener {
                mAlertDialog.dismiss()
            }
        }
    }

    private fun generateList(): List<ExampleItem> {
        val list = ArrayList<ExampleItem>()
        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Fiat Uno",
            "Consumo de gasolina: 11.3",
            "Consumo de etanol: 9.3")
            )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Honda Civic",
            "Consumo de gasolina: 14.4",
            "Consumo de etanol: 10.2")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Chevrolet Celta",
            "Consumo de gasolina: 12.3",
            "Consumo de etanol: 9.8")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Fiat Uno",
            "Consumo de gasolina: 11.3",
            "Consumo de etanol: 9.3")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Honda Civic",
            "Consumo de gasolina: 14.4",
            "Consumo de etanol: 10.2")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Chevrolet Celta",
            "Consumo de gasolina: 12.3",
            "Consumo de etanol: 9.8")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Fiat Uno",
            "Consumo de gasolina: 11.3",
            "Consumo de etanol: 9.3")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Honda Civic",
            "Consumo de gasolina: 14.4",
            "Consumo de etanol: 10.2")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Chevrolet Celta",
            "Consumo de gasolina: 12.3",
            "Consumo de etanol: 9.8")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Fiat Uno",
            "Consumo de gasolina: 11.3",
            "Consumo de etanol: 9.3")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Honda Civic",
            "Consumo de gasolina: 14.4",
            "Consumo de etanol: 10.2")
        )

        list.add(ExampleItem(
            R.drawable.ic_directions_car_white_24dp,
            "Chevrolet Celta",
            "Consumo de gasolina: 12.3",
            "Consumo de etanol: 9.8")
        )

        return list
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
