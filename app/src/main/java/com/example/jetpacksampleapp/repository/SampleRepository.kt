package com.example.jetpacksampleapp.repository

import android.util.Log
import com.example.jetpacksampleapp.api.SampleAPI
import com.example.jetpacksampleapp.models.ListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class SampleRepository @Inject constructor(private val sampleAPI:SampleAPI) {

    private val _category = MutableStateFlow<List<String>>(emptyList())
    val category :StateFlow<List<String>>
        get()=_category

    private val _products = MutableStateFlow<List<ListItem>>(emptyList())
    val products :StateFlow<List<ListItem>>
        get()=_products

    suspend fun getCategory(){

            val response =sampleAPI.getCategory()
            if(response.isSuccessful ) {

                _category.emit(response.body()!!)
            }
    }

    suspend fun getProducts(category: String){
        val response = sampleAPI.getProducts(category)
        if(response.isSuccessful && response.body().isNullOrEmpty()){
            _products.emit(response.body()!!)
        }
    }

}