package com.example.neost.exapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity

import android.os.Bundle
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_api.*
import kotlinx.android.synthetic.main.activity_main.*

class ApiActivity : AppCompatActivity() {

    private var disposable: Disposable? = null

    private val wikiApiServe by lazy {
        ZomatoApiService.create()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api)

        btn_search.setOnClickListener {
            if (edit_search.text.toString().isNotEmpty()) {
                beginSearch(edit_search.text.toString())
            }
        }

    }
    // SearchString = city wanted
    private fun beginSearch(searchString: String) {
        disposable = wikiApiServe.hitCountCheck(searchString,"f2842803635e1d1a3a577e3c168052b4","5")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { result -> txt_search_result.text = "${result.query.name} result found" },
                        { error -> Toast.makeText(this, error.message, Toast.LENGTH_SHORT).show() }
                )
    }

    override fun onPause() {
        super.onPause()
        disposable?.dispose()
    }

    companion object {
        // Méthode static en kotlin
        fun getStartingIntent(callingContext: Context) : Intent =
                Intent(callingContext, ApiActivity::class.java)

    }

}