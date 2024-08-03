package com.example.jetpacksampleapp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.jetpacksampleapp.models.Product
import com.example.jetpacksampleapp.viewmodels.ProductListViewModel


@Composable
fun ProductScreen() {

    val viewModel: ProductListViewModel = hiltViewModel()
    val productList = viewModel.productList.collectAsState()

    if(productList.value.isEmpty()){
        Box(
            modifier = Modifier.fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Loading...", style = MaterialTheme.typography.bodyLarge)
        }
    }else {
        LazyColumn() {
            items(productList.value) {
                ProductItem(it)
            }
        }
    }
}

//@Preview(showSystemUi = true)
@Composable
fun ProductItem(product: Product = Product(1, "title", "small description")) {

    Card(
        elevation = CardDefaults.elevatedCardElevation(),
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .border(1.dp, color = Color.Black)
    ) {
        Column {
            Text(
                text = product.title,
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = product.description,
                modifier = Modifier.padding(5.dp),
                style = MaterialTheme.typography.bodySmall
            )
        }


    }

}