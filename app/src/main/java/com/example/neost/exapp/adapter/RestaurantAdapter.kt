package com.example.neost.exapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.example.neost.exapp.R
import com.example.neost.exapp.Restaurant

/**
 * Created by neost on 24/01/2018.
 */

class RestaurantAdapter(private val restaurantList: List<Restaurant>) : RecyclerView.Adapter<RestaurantAdapter.MyViewHolder>() {




    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView
        var city: TextView
        var desc: TextView



        init {
            name = view.findViewById(R.id.name)
            desc = view.findViewById(R.id.desc)
            city = view.findViewById(R.id.city)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.restaurant_list_row, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val restaurant = restaurantList[position]
        holder.name.text = restaurant.name
        holder.desc.text = restaurant.getDesc()
        holder.city.text = restaurant.city
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }
}