package com.example.sleep.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TrackViewModel : ViewModel() {
    private val model = listOf(
        Track(name = "Night Island", minutes = 45),
        Track(name = "Sweet Sleep", minutes = 25)
    )

    val trackLiveData = MutableLiveData(model)
}