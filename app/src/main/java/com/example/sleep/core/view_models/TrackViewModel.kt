package com.example.sleep.core.view_models

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sleep.core.models.Track

class TrackViewModel : ViewModel() {
    private val model = listOf(
        Track(
            id = 1,
            name = "Sweet Sleep",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 25,
            categories = listOf(2, 5),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 2,
            name = "Good Night",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 28,
            categories = listOf(2, 4),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 3,
            name = "Moon Clouds",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 14,
            categories = listOf(2, 5),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 4,
            name = "Bed Time",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 53,
            categories = listOf(5),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 5,
            name = "Little Star",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 40,
            categories = listOf(4),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 6,
            name = "Night Mist",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 32,
            categories = listOf(5),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 7,
            name = "Early Bird",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 12,
            categories = listOf(2, 4),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 8,
            name = "Full Moon",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 19,
            categories = listOf(2, 4),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 9,
            name = "Night Island",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 45,
            categories = listOf(2, 3),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 10,
            name = "Sweet Sleep",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 25,
            categories = listOf(2, 4),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 11,
            name = "Good Night",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 28,
            categories = listOf(2, 3),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 12,
            name = "Moon Clouds",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 14,
            categories = listOf(2, 5),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 13,
            name = "Bed Time",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 53,
            categories = listOf(3),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 14,
            name = "Little Star",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 40,
            categories = listOf(4),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 15,
            name = "Night Mist",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 32,
            categories = listOf(5),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 16,
            name = "Early Bird",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 12,
            categories = listOf(2, 4),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 17,
            name = "Full Moon",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 19,
            categories = listOf(2, 4),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        ),
        Track(
            id = 18,
            name = "Night Island",
            description = "Ease the mind into a restful night’s sleep with these deep, ambient tones.",
            minutes = 45,
            categories = listOf(2, 3),
            favorites = (Math.random() * 10000 + 100).toInt(),
            listening = (Math.random() * 100).toInt()
        )
    )

    val trackLiveData = MutableLiveData(model)
}