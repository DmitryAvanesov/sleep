package com.example.sleep.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel: ViewModel() {
    private val model = listOf(
        Category(id = 0, name = "All"),
        Category(id = 1, name = "My"),
        Category(id = 2, name = "Anxious"),
        Category(id = 3, name = "Sleep"),
        Category(id = 4, name = "Kids"),
    )

    val categoryLiveData = MutableLiveData(model)
}