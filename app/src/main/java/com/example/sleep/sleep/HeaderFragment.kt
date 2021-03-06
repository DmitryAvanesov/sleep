package com.example.sleep.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.HorizontalScrollView
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.sleep.R
import com.example.sleep.category.CategoryFragment
import com.example.sleep.core.view_models.CategoryViewModel

class HeaderFragment : Fragment() {
    private val categoryViewModel: CategoryViewModel by activityViewModels()
    private lateinit var categoriesView: HorizontalScrollView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_header, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoriesView = view.findViewById(R.id.categories_scroll_view)
        observeCategories()
    }

    private fun observeCategories() {
        categoryViewModel.categoryLiveData.observe(
            viewLifecycleOwner,
            { categories ->
                val categoriesLinearLayout = LinearLayout(requireContext())
                categoriesView.addView(categoriesLinearLayout)

                for ((index, category) in categories.withIndex()) {
                    val categoryLinearLayout = LinearLayout(requireContext())
                    val categoryLinearLayoutParams = LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                    ) as ViewGroup.MarginLayoutParams
                    categoryLinearLayoutParams.leftMargin = if (index == 0) 32 else 16
                    categoryLinearLayoutParams.rightMargin =
                        if (index == categories.size - 1) 32 else 16
                    categoryLinearLayout.layoutParams = categoryLinearLayoutParams
                    categoryLinearLayout.orientation = LinearLayout.VERTICAL
                    categoriesLinearLayout.addView(categoryLinearLayout)

                    val button = ImageButton(requireContext())
                    val buttonLinearLayout =
                        LinearLayout.LayoutParams(160, 160) as ViewGroup.MarginLayoutParams
                    buttonLinearLayout.bottomMargin = 12
                    button.layoutParams = buttonLinearLayout
                    button.setBackgroundResource(if (index == 0) R.drawable.ic_category_button_active else R.drawable.ic_category_button)
                    button.setImageResource(
                        requireContext().resources.getIdentifier(
                            "ic_category_${category.id}",
                            "drawable",
                            requireContext().packageName
                        )
                    )
                    if (index > 0) {
                        button.setOnClickListener {
                            val fragment = CategoryFragment.newInstance(
                                id = category.id,
                                name = category.name
                            )
                            activity?.supportFragmentManager?.beginTransaction()
                                ?.replace(R.id.menu_fragment_container, fragment)
                                ?.commit()
                        }
                    }
                    categoryLinearLayout.addView(button)

                    val textView = TextView(requireContext())
                    textView.text = category.name
                    textView.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    textView.textSize = 14f
                    textView.setTextColor(
                        ContextCompat.getColor(
                            requireContext(),
                            if (index == 0) R.color.light_pink else R.color.pink
                        )
                    )
                    categoryLinearLayout.addView(textView)
                }
            })
    }
}