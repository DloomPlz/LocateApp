package com.example.neost.exapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.TextView
import com.example.neost.exapp.adapter.MyAdapter


class ThirdActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

    }

    companion object {
        // Méthode static en kotlin
        fun getStartingIntent(callingContext: Context) : Intent =
                Intent(callingContext, ThirdActivity::class.java)

    }



}