package com.example.neost.exapp



class Restaurant {
    var name: String? = ""
    var city: String? = ""
    private var desc: String? = ""

    constructor() {}

    constructor(name: String, city: String, desc: String) {
        this.name = name
        this.city = city
        this.desc = desc
    }

    fun getDesc(): String? {
        return desc
    }

    fun setDesc(desc: String) {
        this.desc = desc
    }
}