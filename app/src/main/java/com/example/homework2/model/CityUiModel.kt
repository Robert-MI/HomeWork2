package com.example.homework2.model

data class CityUiModel(
    val name: String,
    val desc: String,
    val imageRes: Int,
    val temperature: Float? = null
)