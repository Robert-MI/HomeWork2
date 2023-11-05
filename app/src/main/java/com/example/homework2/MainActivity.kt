package com.example.homework2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.homework2.ui.theme.HomeWork2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CustomNavigationView()
        }
    }
}

@Composable
fun CustomNavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Screen1") {
        composable(
            route = "Screen1",
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Welcome!", fontSize = 24.sp)
                Spacer(modifier = Modifier.height(100.dp))
                Button(
                    onClick = {
                        navController.navigate(route = "Screen2")
                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text("Navigate to second screen")
                }
            }
        }
        composable(
            route = "Screen2",
        ) {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Text(
                        text = "Yerevan",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.yerevan),
                        contentDescription=null,
                        modifier = Modifier.size(250.dp),
                    )
                    Text(text = "Description: \nCountry: Armenia \nPopulation: 1095000 \nArea: 223km^2")
                    Spacer(modifier = Modifier.height(20.dp))
                }
                item {
                    Text(
                        text = "Washington",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.washington),
                        contentDescription=null,
                        modifier = Modifier.size(250.dp),
                    )
                    Text(text = "Description: \nCountry: USA. \nPopulation: 7951150 \nArea: 177km^2")
                    Spacer(modifier = Modifier.height(20.dp))
                }
                item {
                    Text(
                        text = "Madrid",
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp
                    )
                    Image(
                        painter = painterResource(id = R.drawable.madrid),
                        contentDescription=null,
                        modifier = Modifier.size(250.dp),
                    )
                    Text(text = "Description: \nCountry: Spain \nPopulation: 6751000 \nArea: 604km^2")
                    Spacer(modifier = Modifier.height(20.dp))
                }
                item {
                    Button(
                        onClick = {
                            navController.navigate(route = "Screen1")
                        },
                        modifier = Modifier.padding(8.dp)
                    ) {
                        Text("Navigate to first screen")
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HomeWork2Theme {
//        Greeting("Android")
        CustomNavigationView()
    }
}