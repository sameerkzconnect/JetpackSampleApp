package com.example.jetpacksampleapp.models

data class Product(
    val id:Int,
    val title:String,
    val description:String
)
data class ProductResponse(val products: List<Product>)

