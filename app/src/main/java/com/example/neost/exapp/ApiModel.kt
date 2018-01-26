package com.example.neost.exapp

import android.app.DownloadManager
import java.time.temporal.TemporalQuery
import java.util.jar.Attributes


object ApiModel {
    data class Result(val query: City)
    data class City(val name : String)

}