package com.example.tragosretrofit.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.example.tragosretrofit.R
import com.example.tragosretrofit.domain.model.DomainModel

class DrinkAdapter(private var drinkList:List<DomainModel>,
                   //funcion lambda para el onclick
                   private val onClickListener:(DomainModel)->Unit)
                  :RecyclerView.Adapter<DrinkViewHolder>(),Filterable {

    private val filter = DrinkFilter(this,drinkList)
     var filteredDrinkList: List<DomainModel> = drinkList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrinkViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DrinkViewHolder(layoutInflater.inflate(R.layout.item_list_drink,parent,false))
    }

    override fun onBindViewHolder(holder: DrinkViewHolder, position: Int) {
        val item = filteredDrinkList[position]
        holder.render(item,onClickListener)
    }

    override fun getItemCount(): Int = filteredDrinkList.size

    override fun getFilter(): Filter = filter


}