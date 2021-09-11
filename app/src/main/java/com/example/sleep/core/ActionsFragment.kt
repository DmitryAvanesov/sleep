package com.example.sleep.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sleep.R

class ActionsFragment : Fragment() {
    lateinit var myButton: ImageButton
    private val trackViewModel: TrackViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_actions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myButton = view.findViewById(R.id.actions_my_button)
        handleMyButtonClick()
    }

    private fun handleMyButtonClick() {
        myButton.setOnClickListener {
            trackViewModel.trackLiveData.value = listOf(
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
                )
            )
        }
    }
}