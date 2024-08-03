package com.example.jetpacksampleapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpacksampleapp.repository.SampleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class CategoryViewModel @Inject constructor(private val sampleRepository: SampleRepository)
    : ViewModel(){
    val category: StateFlow<List<String>>
        get() = sampleRepository.category

    init {
        viewModelScope.launch {
            sampleRepository.getCategory()
        }
    }

}