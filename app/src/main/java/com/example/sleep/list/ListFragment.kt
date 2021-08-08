package com.example.sleep.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sleep.R
import com.example.sleep.core.TrackViewModel

class ListFragment : Fragment(R.layout.fragment_list) {
    private val trackViewModel: TrackViewModel by activityViewModels()
    private lateinit var table: TableLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeTracks()
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        table = view.findViewById(R.id.list_table_layout)!!
    }

    private fun observeTracks() {
        trackViewModel.trackLiveData.observe(
            viewLifecycleOwner,
            { tracks ->
                val text = TextView(context)
                text.text = "HMMMMM"
                table.addView(text)
            })
    }
}