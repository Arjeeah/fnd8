package com.example.fnd8.viewmodel

import androidx.lifecycle.ViewModel
import com.example.fnd8.model.User

class UserViewModel:ViewModel(){
    private var users = MutableList<User>()

    fun regestrition(user:User){
        users.add(user)
    }
    fun login(phone:String,password:String):User?{
        var exists = users.any{
            (it.userPhone==phone && it.userPassword==password)
        }
        if (!exists){
            null
        }
        return users.find{ it.userPhone==phone }


    }
}