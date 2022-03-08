package com.aevumdev.carrest.models

data class Car(val id : Number, val model : String, val vendor : String, val price:Number){
    constructor(model:String, vendor:String, price:Number) : this(-1, model,vendor,price)

    override fun toString(): String {
        return "$id $model $vendor $price"
    }
}
