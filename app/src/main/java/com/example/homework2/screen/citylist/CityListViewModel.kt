package com.example.homework2.screen.citylist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework2.R
import com.example.homework2.model.CityUiModel
import com.example.homework2.service.RetrofitHelper
import com.example.homework2.service.WeatherService
import kotlinx.coroutines.launch

private val INITIAL_CITIES = listOf(
    CityUiModel(
        "Yerevan",
        "\nCountry: Armenia \nPopulation: 1095000 \nArea: 223km^2",
        R.drawable.yerevan
    ),
    CityUiModel(
        "Washington",
        "\nCountry: USA. \nPopulation: 7951150 \nArea: 177km^2",
        R.drawable.washington
    ),
    CityUiModel(
        "Madrid",
        "\nCountry: Spain \nPopulation: 6751000 \nArea: 604km^2",
        R.drawable.madrid
    )
)

class CityListViewModel : ViewModel() {
    private val weatherService = RetrofitHelper.retrofit.create(WeatherService::class.java)
    private val _cities = MutableLiveData<List<CityUiModel>>(emptyList())

    val cities: LiveData<List<CityUiModel>> = _cities

    init {
        viewModelScope.launch {
            _cities.postValue(INITIAL_CITIES.map {
                it.copy(
                    temperature = weatherService.fetchWeather(it.name)?.current?.temp_c
                )
            })
        }
    }
}