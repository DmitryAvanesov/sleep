package com.example.sleep.core.models

data class Track(
    val id: Int,
    val name: String,
    val description: String,
    val minutes: Int,
    val categories: List<Int>,
    val favorites: Int,
    val listening: Int
)
