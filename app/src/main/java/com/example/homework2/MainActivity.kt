package com.example.homework2

import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.homework2.screen.citylist.CityListScreen
import com.example.homework2.screen.citylist.CityListViewModel
import com.example.homework2.screen.welcome.WelcomeScreen
import com.example.homework2.ui.theme.HomeWork2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeWork2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.White
                ) {
                    CustomNavigationView()
                }
            }
        }
    }
}


@Composable
fun CustomNavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Welcome") {
        composable(
            route = "Welcome",
        ) {
            WelcomeScreen(navController)
        }
        composable(
            route = "CityList",
        ) {
            CityListScreen(navController, CityListViewModel())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        CustomNavigationView()
    }
}