package com.example.neost.exapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView



class AsyncActivity :AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_async)

        val preLoaderTv  : TextView = findViewById(R.id.PreLoaderTV);
        PreLoader(preLoaderTv).execute("Pates","Nouilles","spaget","ravioli","camembert");

    }

    companion object {
        // Méthode static en kotlin
        fun getStartingIntent(callingContext: Context) : Intent =
                Intent(callingContext, AsyncActivity::class.java)

    }

}