package com.example.neost.exapp

import android.app.FragmentManager
import android.content.Intent
import android.graphics.drawable.Animatable
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton

class MainActivity : LifecycleLoggingActivity() {

    var mIsEditTextVisible : Boolean = false

    lateinit var mEditTextReveal : EditText

    lateinit var mAddButton : ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Cache variable
        mAddButton = findViewById(R.id.btn_add)
        mEditTextReveal = findViewById(R.id.text_edit)

        // Make EditText invisible
        mEditTextReveal.visibility = View.INVISIBLE
        mIsEditTextVisible = false;

        val btn : Button = findViewById(R.id.button_liste)
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

    fun makeMapsIntent(address : String) : Intent
    {
        return Intent (Intent.ACTION_VIEW,
                Uri.parse("geo:0,0?q=" + Uri.encode(address) + " restaurant"))


    }

    fun makeBrowserIntent(address : String) : Intent
    {
        val intent : Intent = Intent (Intent.ACTION_VIEW,
        Uri.parse("geo:0,0?q=" + Uri.encode(address) + " restaurant"))

        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

        return intent
    }

    fun mapAddress(view: View)
    {
        // Start activity to map the adress

        val mAnimatable : Animatable

        if (mIsEditTextVisible)
        {

            // If visible, hide EditText and set bool
            mEditTextReveal.visibility = View.GONE
            mIsEditTextVisible = false;

            // Set image ressource to start morph animation
            mAddButton.setImageResource(R.drawable.icon_morph_reverse)


            startMap()

        }
        else
        {
            // If edit text invisible reveal it using anim and bool to true
            mEditTextReveal.visibility = View.VISIBLE
            mIsEditTextVisible = true

            mEditTextReveal.requestFocus()

            // set image ressource to start morph anim

            mAddButton.setImageResource(R.drawable.icon_morph)

        }
    }

    override fun onStart() {
        super.onStart()

    }

    fun startMap()
    {

            val address : String = mEditTextReveal.text.toString()

            val geoIntent : Intent = makeMapsIntent(address)

            if (geoIntent.resolveActivity(packageManager) != null)
            {
                //Start maps app
                startActivity(geoIntent)
            }
            else
                //Start browser app
                startActivity(makeBrowserIntent(address))


    }




}
