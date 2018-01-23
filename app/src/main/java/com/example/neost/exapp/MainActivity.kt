package com.example.neost.exapp

import android.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn : Button = findViewById(R.id.button)
        btn.setOnClickListener(View.OnClickListener {
         startActivity(SecondActivity.getStartingIntent(this))
            //finish()
        })

        val btnFragment : Button = findViewById(R.id.button_fragment)
        btnFragment.setOnClickListener(View.OnClickListener {
            val fragmentManager = supportFragmentManager
            fragmentManager?.beginTransaction()?.replace(R.id.fragment_main,MyFragment())?.commit()
        })
    }




}
