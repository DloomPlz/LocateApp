package com.example.neost.exapp

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log

/**
 * Created by neost on 23/01/2018.
 */
public abstract class LifecycleLoggingActivity : AppCompatActivity()
{
    public val TAG : String = "test"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState != null)
        {
            Log.d(TAG, "onCreate() : activity recreated")
        }
    }

    override fun onStart()
    {
        super.onStart()
        Log.d(TAG, "onStart() - activity is about to be started")
    }

    override fun onResume()
    {
        super.onResume()
        Log.d(TAG, "onResume() - activity has become visible (is is now " + "\"resumed\")")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() - another activity is taking focus (this activity " + "is about to be \"paused\")")
    }

    override fun onStop()
    {
        super.onStop()
        Log.d(TAG,"onStop() - activity is no longer visible (it is now " + "\"stopped\")")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart() - activity is about to be restarted()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy - activity is about to be destroyed")
    }

}