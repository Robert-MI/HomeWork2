package com.example.homework2.model

data class WeatherResponse(
    val current: Current
)

data class Current(
    val temp_c: Float
)