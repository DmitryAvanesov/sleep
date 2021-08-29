package com.example.sleep.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrackViewModel : ViewModel() {
    private val model = listOf(
        Track(id = 0, name = "Night Island", minutes = 45, categories = listOf(1, 3)),
        Track(id = 1, name = "Sweet Sleep", minutes = 25, categories = listOf(1, 4)),
        Track(id = 2, name = "Good Night", minutes = 28, categories = listOf(1, 2)),
        Track(id = 3, name = "Moon Clouds", minutes = 14, categories = listOf(2)),
        Track(id = 4, name = "Bed Time", minutes = 53, categories = listOf(3)),
        Track(id = 5, name = "Little Star", minutes = 40, categories = listOf(4)),
        Track(id = 6, name = "Night Mist", minutes = 32, categories = listOf(4)),
        Track(id = 7, name = "Early Bird", minutes = 12, categories = listOf(1, 4)),
        Track(id = 8, name = "Full Moon", minutes = 19, categories = listOf(1, 4)),
        Track(id = 9, name = "Night Island", minutes = 45, categories = listOf(1, 3)),
        Track(id = 10, name = "Sweet Sleep", minutes = 25, categories = listOf(1, 4)),
        Track(id = 11, name = "Good Night", minutes = 28, categories = listOf(1, 2)),
        Track(id = 12, name = "Moon Clouds", minutes = 14, categories = listOf(2)),
        Track(id = 13, name = "Bed Time", minutes = 53, categories = listOf(3)),
        Track(id = 14, name = "Little Star", minutes = 40, categories = listOf(4)),
        Track(id = 15, name = "Night Mist", minutes = 32, categories = listOf(4)),
        Track(id = 16, name = "Early Bird", minutes = 12, categories = listOf(1, 4)),
        Track(id = 17, name = "Full Moon", minutes = 19, categories = listOf(1, 4)),
    )

    val trackLiveData = MutableLiveData(model)
}