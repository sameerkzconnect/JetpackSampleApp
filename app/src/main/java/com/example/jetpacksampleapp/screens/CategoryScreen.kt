package com.example.jetpacksampleapp.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpacksampleapp.R
import com.example.jetpacksampleapp.viewmodels.CategoryViewModel


@SuppressLint("SuspiciousIndentation")
@Composable
fun CategoryScreen( ){
    val categoryViewModel:CategoryViewModel = hiltViewModel()
    val category = categoryViewModel.category.collectAsState()
        Log.d("TAG","cat"+category.value.size)

    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround
    ) {

        items(category.value) {
            CategoryItem(category = it)
        }

        }

}

//@Preview(showSystemUi = true)
@Composable
fun CategoryItem(modifier: Modifier=Modifier,category: String="Item",){

    Box(modifier =
    Modifier
        .padding(16.dp)
        .size(160.dp)
        .clip(RoundedCornerShape(16.dp))
        .paint(painter = painterResource(id = R.drawable.bg_cat_item),
            contentScale = ContentScale.Crop)
        .border(1.dp, color = Color.Black, RoundedCornerShape(16.dp)),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier=Modifier.padding(10.dp),
            text = category,
            fontSize = 22.sp,
            color = Color.White,
            style = MaterialTheme.typography.bodyLarge
        )
    }

}