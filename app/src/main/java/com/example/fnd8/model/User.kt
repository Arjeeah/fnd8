package com.example.fnd8.model

data class User(
    var userName:String,
    var userPhone : String,
    var userPassword :String,
    var userCart: MutableList<CartItem>
)
