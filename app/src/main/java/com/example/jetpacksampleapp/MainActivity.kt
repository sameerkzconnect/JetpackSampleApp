package com.example.jetpacksampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpacksampleapp.screens.CategoryScreen
import com.example.jetpacksampleapp.screens.ProductScreen
import com.example.jetpacksampleapp.ui.theme.JetpackSampleAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackSampleAppTheme {
                //  CategoryScreen()

                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = "Sample App", color = Color.White)
                            },
                           colors =  TopAppBarDefaults.topAppBarColors(
                               containerColor = Color.Black
                           )
                        )
                    },

                ) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        App()
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun App() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "category") {
        composable(route = "category") {
            CategoryScreen{
                navController.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) {
            ProductScreen()
        }
    }
}



