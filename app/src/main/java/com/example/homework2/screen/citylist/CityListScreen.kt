package com.example.homework2.screen.citylist

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun CityListScreen(
    navController: NavController,
    viewModel: CityListViewModel
) {
    val cities = viewModel.cities.observeAsState().value
    if (cities.isNullOrEmpty()) {
        CircularProgressIndicator()
        return
    }
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(cities) {city->
            Text(
                text = city.name,
                fontWeight = FontWeight.Bold,
                fontSize = 30.sp
            )
            Image(
                painter = painterResource(id = city.imageRes),
                contentDescription=null,
                modifier = Modifier.size(250.dp),
            )
            Text(text = "Description:" + city.desc)
            Spacer(modifier = Modifier.height(20.dp))
            city.temperature?.let { temp ->
                Text(text= "Temperature:" + temp.toString() + "C")
            }
        }
        item {
            Button(
                onClick = {
                    navController.navigate(route = "Welcome")
                },
                modifier = Modifier.padding(8.dp)
            ) {
                Text("Navigate to first screen")
            }
        }
    }
}

