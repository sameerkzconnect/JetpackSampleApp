package com.example.jetpacksampleapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacksampleapp.models.Product
import com.example.jetpacksampleapp.repository.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val sampleRepository: SampleRepository
) :ViewModel(){

    val productList: StateFlow<List<Product>>
        get() = sampleRepository.products

    init {
        viewModelScope.launch {
            sampleRepository.getProducts("smartphones")
        }
    }
}