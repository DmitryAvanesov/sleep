package com.example.sleep.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.TableRow
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sleep.R
import com.example.sleep.core.TrackViewModel

class ListFragment : Fragment(R.layout.fragment_list) {
    private val trackViewModel: TrackViewModel by activityViewModels()
    private lateinit var tableLayout: TableLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeTracks()
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tableLayout = view.findViewById(R.id.list_table_layout)
    }

    private fun observeTracks() {
        trackViewModel.trackLiveData.observe(
            viewLifecycleOwner,
            { tracks ->
                tableLayout.removeAllViews()
                var tableRow = TableRow(requireContext())

                for ((index, track) in tracks.withIndex()) {
                    if (index % 2 == 0) {
                        tableRow = TableRow(requireContext())
                        tableLayout.addView(tableRow)
                    }

                    val linearLayout = LinearLayout(requireContext())
                    linearLayout.setHorizontalGravity(if (index % 2 == 0) android.view.Gravity.START else android.view.Gravity.END)
                    tableRow.addView(linearLayout)

                    val cardView = CardView(requireContext())
                    cardView.radius = 36f
                    linearLayout.addView(cardView)

                    val imageView = ImageView(requireContext())
                    imageView.setImageResource(
                        requireContext().resources.getIdentifier(
                            "track_${track.id}",
                            "drawable",
                            requireContext().packageName
                        )
                    )
                    cardView.addView(imageView)
                }
            })
    }
}