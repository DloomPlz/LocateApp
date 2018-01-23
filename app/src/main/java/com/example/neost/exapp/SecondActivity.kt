package com.example.neost.exapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.neost.exapp.adapter.MyAdapter

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val recycler : RecyclerView = findViewById(R.id.recycler_view)
        recycler.setHasFixedSize(true)
        recycler.layoutManager= LinearLayoutManager(this)
        val adapter : MyAdapter = MyAdapter(this)
        val list : ArrayList<String> = ArrayList()
        list.add("Salut")
        list.add("je")
        adapter.setData( list)
        recycler.adapter = adapter
    }

    companion object {
        // Méthode static en kotlin
        fun getStartingIntent(callingContext: Context) : Intent =
            Intent(callingContext, SecondActivity::class.java)

}

}