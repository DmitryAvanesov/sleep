package com.example.sleep.list

import android.content.Intent
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
import com.example.sleep.category.CategoryActivity
import com.example.sleep.core.Category
import com.example.sleep.core.CategoryViewModel
import com.example.sleep.core.TrackViewModel
import com.example.sleep.track.TrackActivity

class ListFragment : Fragment() {
    private val trackViewModel: TrackViewModel by activityViewModels()
    private lateinit var tableLayout: TableLayout
    private val categoryViewModel: CategoryViewModel by activityViewModels()
    private lateinit var categoryName: String

    companion object {
        @JvmStatic
        fun newInstance(categoryId: Int) = ListFragment().apply {
            arguments = Bundle().apply {
                putInt("categoryId", categoryId)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeCategories()
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        tableLayout = view.findViewById(R.id.list_table_layout)
    }

    private fun observeCategories() {
        categoryViewModel.categoryLiveData.observe(
            viewLifecycleOwner,
            { categories ->
                observeTracks(categories)
            })
    }

    private fun observeTracks(categories: List<Category>) {
        trackViewModel.trackLiveData.observe(
            viewLifecycleOwner,
            { tracks ->
                tableLayout.removeAllViews()
                var tableRow = TableRow(requireContext())
                val categoryId = arguments?.getInt("categoryId")
                val tracksFilteredByCategory = if (categoryId != 0) tracks.filter { track ->
                    track.categories.contains(categoryId)
                } else tracks

                for ((index, track) in tracksFilteredByCategory.withIndex()) {
                    if (categoryId == 0 || track.categories.contains(categoryId)) {
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
                        itemLinearLayout.setOnClickListener {
                            val intent = Intent(activity, TrackActivity::class.java)
                            intent.putExtra("id", track.id)
                            intent.putExtra("name", track.name)
                            startActivity(intent)
                        }
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
                        infoTextView.text = getString(
                            R.string.list_info,
                            track.minutes,
                            categories.find { category ->
                                category.id != 1 && track.categories.contains(category.id)
                            }?.name?.uppercase()
                        )
                        infoTextView.setTextColor(
                            ContextCompat.getColor(
                                requireContext(),
                                R.color.pink
                            )
                        )
                        infoTextView.textSize = 13f
                        itemLinearLayout.addView(infoTextView)

                        if (leftCard) {
                            val space = Space(requireContext())
                            space.layoutParams = LinearLayout.LayoutParams(
                                36, LinearLayout.LayoutParams.MATCH_PARENT
                            )
                            rowLinearLayout.addView(space)
                        }
                    }
                }
            })
    }
}