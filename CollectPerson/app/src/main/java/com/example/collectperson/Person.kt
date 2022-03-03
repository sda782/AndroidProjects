package com.example.collectperson

import java.io.Serializable

data class Person(var id:Number, val name :String, val age:Number, val address:String, val shoeSize:Number):
    Serializable {
    override fun toString(): String {
        return "Id $id Name $name Age $age Address $address  ShoeSize$shoeSize"
    }
}