package com.example.sleep.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sleep.R
import com.example.sleep.core.CategoryViewModel

class HeaderFragment : Fragment() {
    private val categoryViewModel: CategoryViewModel by activityViewModels()
    private lateinit var categoriesView: HorizontalScrollView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        observeCategories()
        return inflater.inflate(R.layout.fragment_header, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        categoriesView = view.findViewById(R.id.categories_scroll_view)
    }

    private fun observeCategories() {
        categoryViewModel.categoryLiveData.observe(
            viewLifecycleOwner,
            { categories ->
                val categoriesLinearLayout = LinearLayout(requireContext())
                categoriesView.addView(categoriesLinearLayout)

                for ((index, category) in categories.withIndex()) {
                    val categoryLinearLayout = LinearLayout(requireContext())
                    categoryLinearLayout.orientation = LinearLayout.VERTICAL
                    val categoryLinearLayoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                    ) as ViewGroup.MarginLayoutParams
                    categoryLinearLayoutParams.leftMargin = if (index == 0) 32 else 10
                    categoryLinearLayoutParams.rightMargin =
                        if (index == categories.size - 1) 32 else 10
                    categoryLinearLayout.layoutParams = categoryLinearLayoutParams
                    categoriesLinearLayout.addView(categoryLinearLayout)

                    val button = Button(requireContext())
                    button.layoutParams = LinearLayout.LayoutParams(128, 128)
                    button.setBackgroundResource(if (index == 0) R.drawable.category_button_active else R.drawable.category_button)
                    categoryLinearLayout.addView(button)
                }
            })
    }
}