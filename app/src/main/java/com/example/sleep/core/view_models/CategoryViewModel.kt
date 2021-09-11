package com.example.sleep.core.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sleep.core.models.Category

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