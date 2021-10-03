package com.example.a160418034_projectuts.model

data class Recipe(
    val id:String?,
    val name:String?,
    val Kategori:String?,
    val Recipe:String?,
    val description:String?,
    val step:String?,
    val photoUrl:String?,
    val favorite:Int?
)

data class User(
    val id:String?,
    val Username:String?,
    val password:String?,
    val address:String?,
    val phone:String?,
    val photoUrl:String?
)

data class Kategori(
    val id:String?,
    val name:String?,
)
