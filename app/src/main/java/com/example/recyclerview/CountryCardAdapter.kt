package com.example.recyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private var TAG = "prakash"
class CountryCardAdapter(var countries : List<Country>) : RecyclerView.Adapter<CountryCardAdapter.CountryCardViewHolder>() {

    inner class CountryCardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryCardViewHolder {

        Log.d(TAG,"onCreateViewHolder called")

        var layout = R.layout.country_card

        if (viewType == 2) {
            layout = R.layout.reddoorz_card
        }else if(viewType == 3){
            layout = R.layout.anime_city_card
        }

        val view = LayoutInflater.from(parent.context).inflate(layout, parent, false)
        return CountryCardViewHolder(view)

    }

    override fun getItemCount(): Int {
        Log.d(TAG,"getItemCount called")
        return countries.size
    }

    override fun getItemViewType(position: Int): Int {

        Log.d(TAG,"getItemViewType called")

        if (countries[position].code.toDouble() % 2.0 == 0.0) {
            return 2
        }else if(countries[position].code.toDouble()%3.0 == 0.0){
            return 3
        }

        return 0
    }

    override fun onBindViewHolder(holder: CountryCardViewHolder, position: Int) {

        Log.d(TAG,"onBindViewHolder called")

        if(countries[position].code.toDouble()%2.0 != 0.0 && countries[position].code.toDouble()%3.0 != 0.0){
            holder.apply {
                val country: TextView = holder.itemView.findViewById(R.id.countryName)
                country.text = countries[position].name
            }
        }
//        holder.itemView.apply {
//           val country: TextView = holder.itemView.findViewById(R.id.countryName)
//            country.text = countries[position].name

//            val code: TextView = holder.itemView.findViewById(R.id.countryCode)
//            code.text = countries[position].code
 //       }
    }
}
