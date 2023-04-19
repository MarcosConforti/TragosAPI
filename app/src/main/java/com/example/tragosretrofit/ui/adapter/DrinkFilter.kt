package com.example.tragosretrofit.ui.adapter

import android.widget.Filter
import com.example.tragosretrofit.domain.model.DomainModel

class DrinkFilter(
    private val adapter: DrinkAdapter,
    private val originalList: List<DomainModel>
) : Filter() {

    override fun performFiltering(constraint: CharSequence?): FilterResults {
        val filterString = constraint.toString()
        val results = FilterResults()
        val list = originalList

        val filteredList: List<DomainModel> = if (filterString.isEmpty()) {
            list
        } else {
            list.filter {
                it.drinks.contains(filterString, true)
            }
        }

        results.values = filteredList
        results.count = filteredList.size

        return results
    }

    @Suppress("UNCHECKED_CAST")
    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter.filteredDrinkList = results?.values as List<DomainModel>
        adapter.notifyDataSetChanged()
    }

}
