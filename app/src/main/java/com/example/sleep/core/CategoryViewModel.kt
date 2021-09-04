package com.example.sleep.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CategoryViewModel: ViewModel() {
    private val model = listOf(
        Category(id = 1, name = "All"),
        Category(id = 2, name = "My"),
        Category(id = 3, name = "Anxious"),
        Category(id = 4, name = "Sleep"),
        Category(id = 5, name = "Kids"),
    )

    val categoryLiveData = MutableLiveData(model)
}