package com.goblintechs.flex_gasolinaouetanol.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import com.goblintechs.flex_gasolinaouetanol.R
import com.goblintechs.flex_gasolinaouetanol.adapters.ListCarAdapter
import com.goblintechs.flex_gasolinaouetanol.classes.ExampleItem
import com.goblintechs.flex_gasolinaouetanol.models.Car
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.cars_activity.*
import kotlinx.android.synthetic.main.dialog_car.*
import kotlinx.android.synthetic.main.dialog_car.view.*
import kotlinx.android.synthetic.main.dialog_car.view.etNameCar
import kotlinx.android.synthetic.main.dialog_car.view.tlNameCar

class CarsActivity : AppCompatActivity() {
    private val referencia: DatabaseReference = FirebaseDatabase.getInstance().getReference()

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
            mDialogView.btCarSave.setOnClickListener {
                valFields(mDialogView)

                if (mDialogView.etNameCar.text!!.isNotEmpty() &&
                    mDialogView.etGasCarConsum.text!!.isNotEmpty() &&
                    mDialogView.etEthaCarConsum.text!!.isNotEmpty()) {

                    val nameCar = mDialogView.etNameCar.text.toString()
                    val gasConsum = mDialogView.etGasCarConsum.text.toString()
                    val ethaConsum = mDialogView.etEthaCarConsum.text.toString()

                    val car = Car(nameCar, gasConsum, ethaConsum)
                    val usuarios: DatabaseReference = referencia.child("usuarios")
                    val user = FirebaseAuth.getInstance().currentUser
                    val uid = user?.uid
                    usuarios.child(uid.toString()).child("carros").push().setValue(car)

                    mAlertDialog.dismiss()
                }

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

    private fun valFields(dialogView: View) {
        if (dialogView.etNameCar.text!!.isEmpty()) {
            dialogView.tlNameCar.isErrorEnabled = true
            dialogView.tlNameCar.error = getString(R.string.name_car_error)
        }
        else {
            dialogView.tlNameCar.isErrorEnabled = false
        }

        if (dialogView.etGasCarConsum.text.toString().isEmpty()) {
            dialogView.tlGasCarConsum.isErrorEnabled = true
            dialogView.tlGasCarConsum.error = getString(R.string.gasoline_consum_error)
        }
        else {
            dialogView.tlGasCarConsum.isErrorEnabled = false
        }

        if (dialogView.etEthaCarConsum.text!!.isEmpty()) {
            dialogView. tlEthaCarConsum.isErrorEnabled = true
            dialogView. tlEthaCarConsum.error = getString(R.string.ethanol_consum_error)
        }
        else {
            dialogView.tlEthaCarConsum.isErrorEnabled = false
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}
