package com.example.jetpacksampleapp.api

import com.example.jetpacksampleapp.models.Product
import com.example.jetpacksampleapp.models.ProductResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

//interface for calling API
interface SampleAPI {

    @GET(value = "https://dummyjson.com/products/category/{category}")
    suspend fun getProducts(@Path("category") category: String):Response<ProductResponse>

    @GET(value = "/products/category-list")
    suspend fun getCategory():Response<List<String>>

}