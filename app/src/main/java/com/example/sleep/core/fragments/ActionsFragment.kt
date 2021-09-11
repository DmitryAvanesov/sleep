package com.example.sleep.core.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.sleep.R
import java.util.*

class ActionsFragment : Fragment() {
    lateinit var myButton: ImageButton
    lateinit var downloadButton: ImageButton

    companion object {
        @JvmStatic
        fun newInstance(my: Boolean) = ActionsFragment().apply {
            arguments = Bundle().apply {
                putBoolean("my", my)
            }
        }
    }

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
        downloadButton = view.findViewById(R.id.actions_download_button)
        handleExtras()
    }

    private fun handleExtras() {
        if (arguments?.getBoolean("my") == true) {
            myButton.setBackgroundResource(R.drawable.ic_semi_transparent_button_background)
        }
    }
}