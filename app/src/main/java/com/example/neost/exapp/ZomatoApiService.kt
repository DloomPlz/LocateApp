package com.example.neost.exapp

import android.graphics.ColorSpace
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Query


interface ZomatoApiService {
    @GET("api.php")
    fun hitCountCheck(@Query("q") q: String,
                      @Query("apikey") apikey: String,
                      @Query("count") count: String): Observable<ApiModel.Result>

    companion object {
        fun create(): ZomatoApiService {

            val retrofit = Retrofit.Builder()
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://developers.zomato.com/api/")
                    .build()

            return retrofit.create(ZomatoApiService::class.java)
        }
    }
}