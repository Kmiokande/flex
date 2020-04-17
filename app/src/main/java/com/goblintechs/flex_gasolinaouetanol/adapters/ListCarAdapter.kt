package com.goblintechs.flex_gasolinaouetanol.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.goblintechs.flex_gasolinaouetanol.R
import com.goblintechs.flex_gasolinaouetanol.classes.ExampleItem
import kotlinx.android.synthetic.main.list_item.view.*

class ListCarAdapter(private val carsList: List<ExampleItem>): RecyclerView.Adapter<ListCarAdapter.ListCarViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCarViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ListCarViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ListCarViewHolder, position: Int) {
        val currentItem = carsList[position]
        holder.iconCar.setImageResource(currentItem.imageResource)
        holder.tvNameCar.text = currentItem.carName
        holder.tvGasConsum.text = currentItem.gasConsum
        holder.tvEthaConsum.text = currentItem.ethaConsum
    }

    override fun getItemCount() = carsList.size

    class ListCarViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val iconCar: ImageView = itemView.iconCar
        val tvNameCar: TextView = itemView.tvNameCar
        val tvGasConsum: TextView = itemView.tvGasConsum
        val tvEthaConsum: TextView = itemView.tvEthaConsum
    }
}