package com.example.sleep.core.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.example.sleep.R

class ActionsFragment : Fragment() {
    lateinit var myButton: ImageButton
    lateinit var downloadButton: ImageButton

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
        handleMyButtonClick()
        handleDownloadButtonClick()
    }

    private fun handleMyButtonClick() {}

    private fun handleDownloadButtonClick() {}
}