package com.example.fnd8.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.fnd8.model.CartItem
import com.example.fnd8.model.User

class UserViewModel:ViewModel(){
    private var users = mutableStateListOf<User>(
        User(userName = "ali",
            userPassword = "123",
            userPhone = "123",
            userCart = mutableStateListOf<CartItem>(),
            ),
    )
    fun regestrition(user:User){
        users.add(user)
    }
    fun login(phone:String,password:String):User?{
        return users.find{ it.userPhone==phone && it.userPassword==password }
    }
    fun getItems(user:User)=user.userCart
    fun addItems(user:User,item:CartItem)=user.userCart?.add(item)
    fun removeItems(user:User,item:CartItem)=user.userCart?.remove(item)
}