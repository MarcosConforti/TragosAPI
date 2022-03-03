package com.example.tragosretrofit.ui.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tragosretrofit.R
import com.example.tragosretrofit.data.model.DrinkModel

class DrinkAdapter(private val drinkList:List<DrinkModel>):RecyclerView.Adapter<DrinkViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DrinkViewHolder(layoutInflater.inflate(R.layout.item_list_drink,parent,false))
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val item = drinkList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = drinkList.size
}