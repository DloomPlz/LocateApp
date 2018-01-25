package com.example.neost.exapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.annotation.UiThread
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView

import com.example.neost.exapp.adapter.MyAdapter
import kotlinx.android.synthetic.main.activity_second.*
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.anko.*
import java.net.URL

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val preLoaderTv  : TextView = findViewById(R.id.PreLoaderTV);


        PreLoader(preLoaderTv).execute("France","Allemagne","Italie","Norvège","Irlande");
        val recycler : RecyclerView = findViewById(R.id.recycler_view)
        recycler.setHasFixedSize(true)
        recycler.layoutManager= LinearLayoutManager(this)
        val adapter : MyAdapter = MyAdapter(this)
        val list : ArrayList<String> = ArrayList()
        list.add("Pays :")
        adapter.setData( list)
        recycler.adapter = adapter


    }

    companion object {
        // Méthode static en kotlin
        fun getStartingIntent(callingContext: Context) : Intent =
            Intent(callingContext, SecondActivity::class.java)

}




}