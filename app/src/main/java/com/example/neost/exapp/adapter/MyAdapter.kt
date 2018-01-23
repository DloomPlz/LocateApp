package com.example.neost.exapp.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.neost.exapp.R
import kotlinx.android.synthetic.main.layout_cells.*
import kotlinx.android.synthetic.main.layout_cells.view.*

/**
 * Created by neost on 23/01/2018.
 */

class MyAdapter(val context : Context) : RecyclerView.Adapter<MyAdapter.ItemViewHolder>() {

    private var list : ArrayList<String> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.layout_cells, parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder?, position: Int) {
        //holder est l'objet cellule
        holder?.itemView?.cells_text_view?.text = list[position]
    }

    override fun getItemCount(): Int {
        return this.list.size;
    }

    fun setData(list : ArrayList<String>) {
        this.list = list
        notifyDataSetChanged()
    }

    class ItemViewHolder(item : View) : RecyclerView.ViewHolder(item)



}