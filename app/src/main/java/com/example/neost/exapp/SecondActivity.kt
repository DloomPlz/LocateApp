package com.example.neost.exapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.example.neost.exapp.adapter.MyAdapter
import com.example.neost.exapp.adapter.RestaurantAdapter
import kotlinx.android.synthetic.main.activity_second.*
import java.util.ArrayList

class SecondActivity : AppCompatActivity() {

    private val RestaurantList = ArrayList<Restaurant>()
    private var recyclerView: RecyclerView? = null
    private var mAdapter: RestaurantAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //var toolbar : Toolbar = findViewById(R.id.toolbar)
        //setSupportActionBar(toolbar)

       // val preLoaderTv  : TextView = findViewById(R.id.PreLoaderTV);
       // PreLoader(preLoaderTv).execute("France","Allemagne","Italie","Norvège","Irlande");

        recyclerView  = findViewById(R.id.recycler_view)

        mAdapter = RestaurantAdapter(RestaurantList)
        val mLayoutManager = LinearLayoutManager(applicationContext)
        recyclerView!!.layoutManager = mLayoutManager
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = mAdapter

        prepareRestaurantData()
    }

    private fun prepareRestaurantData() {
        var Restaurant = Restaurant("Dominoes pizza", "Angers, 53 rue Deschamps", "Chaine de livraison de pizzas à domicile")
        RestaurantList.add(Restaurant)

        Restaurant = Restaurant("Risorante Del Arte", "Angers Espace Anjour", "Chaine de restaurants italiens")
        RestaurantList.add(Restaurant)

        Restaurant = Restaurant("La côte de boeuf", "Angers - 105 rue de la Madeleine", "Restaurant Francais Typique")
        RestaurantList.add(Restaurant)

        Restaurant = Restaurant("L'instinct gourmand", "Nantes - 014 Rue St Leonard", "Restaurant")
        RestaurantList.add(Restaurant)

        Restaurant = Restaurant("le fou du roi", "Nantes - 2 rue Premion", "Plats classiques et murs en pierre")
        RestaurantList.add(Restaurant)

        Restaurant = Restaurant("Le Baco Saveurs", "Nantes - 8 Allée Baco", "Cuisine française moderne")
        RestaurantList.add(Restaurant)

        Restaurant = Restaurant("Le galopin", "Rennes - 21 Avenue Jean Janvier", "Brasserie rétro chic avec terrasse")
        RestaurantList.add(Restaurant)

        Restaurant = Restaurant("La Fontaine aux Perles", "Rennes - 96 Rue de la poterie", "table raffinée dans un manoir chic")
        RestaurantList.add(Restaurant)

        Restaurant = Restaurant("Le Grill", "35 rue Poullain Duparc", "Cuisine francaise moderne")
        RestaurantList.add(Restaurant)


        mAdapter!!.notifyDataSetChanged()
    }

    companion object {
        // Méthode static en kotlin
        fun getStartingIntent(callingContext: Context) : Intent =
            Intent(callingContext, SecondActivity::class.java)

}

}