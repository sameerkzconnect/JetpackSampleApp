package com.example.jetpacksampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.jetpacksampleapp.api.SampleAPI
import com.example.jetpacksampleapp.screens.CategoryScreen
import com.example.jetpacksampleapp.screens.ProductScreen
import com.example.jetpacksampleapp.ui.theme.JetpackSampleAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackSampleAppTheme {
                  //  CategoryScreen()
                ProductScreen()
//                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                     CategoryScreen(innerPadding)
//                }
            }
        }
    }
}

