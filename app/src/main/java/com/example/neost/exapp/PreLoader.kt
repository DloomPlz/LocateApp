package com.example.neost.exapp

import android.os.AsyncTask
import android.util.Log
import android.widget.TextView

class PreLoader(private val ui_statusLabel: TextView) : AsyncTask<String, Int, String>() {

    override fun doInBackground(vararg params: String): String? {
        var handleParamAccount = 0
        var string : String = "" ;
        for (param in params) {
            Log.i("PreLoaderCheck", "Start" + param)
            try {
                string += " "+ param;
                Thread.sleep(2000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            Log.i("PreLoaderCheck", "Ended" + param)
            handleParamAccount++
            val progress = (handleParamAccount / params.size.toFloat() * 100).toInt()
            publishProgress(progress)
        }


        return string;

    }

    override fun onProgressUpdate(vararg values: Int?) {
        super.onProgressUpdate(*values)
        ui_statusLabel.text = values[0].toString() + "/100"
    }


    override fun onPreExecute() {
        super.onPreExecute()
        ui_statusLabel.text = "cache Loading started"


    }

    override fun onPostExecute(e: String) {
        super.onPostExecute(e)
        var myResult : String;
        val sep : List<String> = e.split(" ")
        myResult = sep[0] + "\n" + sep[1]+ "\n" + sep[2]+ "\n" + sep[3]+ "\n" + sep[4]
        ui_statusLabel.text = myResult;
    }

}