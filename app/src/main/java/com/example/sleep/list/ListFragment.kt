package com.example.sleep.list

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sleep.R
import com.example.sleep.core.CategoryViewModel
import com.example.sleep.core.TrackViewModel

class ListFragment : Fragment() {
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
                    val leftCard = index % 2 == 0

                    if (index % 2 == 0) {
                        tableRow = TableRow(requireContext())
                        tableLayout.addView(tableRow)
                    }

                    val rowLinearLayout = LinearLayout(requireContext())
                    rowLinearLayout.setHorizontalGravity(if (leftCard) android.view.Gravity.START else android.view.Gravity.END)
                    tableRow.addView(rowLinearLayout)

                    val itemLinearLayout = LinearLayout(requireContext())
                    val itemLinearLayoutLayoutParams = LinearLayout.LayoutParams(
                        177,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1f
                    ) as ViewGroup.MarginLayoutParams
                    itemLinearLayoutLayoutParams.bottomMargin = 24
                    itemLinearLayout.layoutParams = itemLinearLayoutLayoutParams
                    itemLinearLayout.orientation = LinearLayout.VERTICAL
                    rowLinearLayout.addView(itemLinearLayout)

                    val cardView = CardView(requireContext())
                    val cardViewLayoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                    ) as ViewGroup.MarginLayoutParams
                    cardViewLayoutParams.bottomMargin = 12
                    cardView.layoutParams = cardViewLayoutParams
                    cardView.radius = 36f
                    itemLinearLayout.addView(cardView)

                    val imageView = ImageView(requireContext())
                    imageView.setImageResource(
                        requireContext().resources.getIdentifier(
                            "track_${track.id}",
                            "drawable",
                            requireContext().packageName
                        )
                    )
                    imageView.scaleType = ImageView.ScaleType.CENTER_CROP
                    cardView.addView(imageView)

                    val nameTextView = TextView(requireContext())
                    nameTextView.text = track.name
                    nameTextView.textSize = 18f
                    nameTextView.typeface = Typeface.DEFAULT_BOLD
                    nameTextView.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.light_pink
                        )
                    )
                    itemLinearLayout.addView(nameTextView)

                    val infoTextView = TextView(requireContext())
                    infoTextView.text = getString(R.string.list_info, track.minutes)
                    infoTextView.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            R.color.pink
                        )
                    )
                    itemLinearLayout.addView(infoTextView)

                    if (leftCard) {
                        val space = Space(requireContext())
                        space.layoutParams = LinearLayout.LayoutParams(
                            36, LinearLayout.LayoutParams.MATCH_PARENT
                        )
                        rowLinearLayout.addView(space)
                    }
                }
            })
    }
}