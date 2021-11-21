package com.example.a160418034_projectuts.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a160418034_projectuts.model.User

class UserModel: ViewModel() {
    val UserLD = MutableLiveData<User>()

    fun fetch() {
        val user1 = User( "Lauren","123","Basuki Rahmat","123456789", "http://dummyimage.com/75x100.jpg/5fa2dd/ffffff")
        UserLD.value = user1
    }

}