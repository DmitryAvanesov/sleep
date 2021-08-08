package com.example.sleep.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrackViewModel : ViewModel() {
    private val model = listOf(
        Track(id = 0, name = "Night Island", minutes = 45),
        Track(id = 1, name = "Sweet Sleep", minutes = 25),
        Track(id = 2, name = "Good Night", minutes = 28),
        Track(id = 3, name = "Moon Clouds", minutes = 14),
        Track(id = 4, name = "Bed Time", minutes = 53),
        Track(id = 5, name = "Little Star", minutes = 40),
        Track(id = 6, name = "Night Mist", minutes = 32),

    )

    val trackLiveData = MutableLiveData(model)
}