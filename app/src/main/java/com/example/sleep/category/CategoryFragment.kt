package com.example.sleep.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.sleep.R
import com.example.sleep.core.ListFragment
import com.example.sleep.sleep.SleepFragment

class CategoryFragment: Fragment() {
    lateinit var categoryTitle: TextView
    lateinit var categoryBackButton: ImageButton

    companion object {
        @JvmStatic
        fun newInstance(id: Int, name: String) = CategoryFragment().apply {
            arguments = Bundle().apply {
                putInt("id", id)
                putString("name", name)
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setListFragment()
        return inflater.inflate(R.layout.fragment_category, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        categoryTitle = view.findViewById(R.id.category_title)
        categoryBackButton = view.findViewById(R.id.category_back_button)
        handleExtras()
        handleBackButtonClick()
    }

    private fun handleExtras() {
        categoryTitle.text = getString(
            R.string.category_title,
            arguments?.getString("name")
        )
    }

    private fun setListFragment() {
        val fragment = arguments?.let {
            ListFragment.newInstance(
                categoryId = it.getInt("id"),
                trackId = 0
            )
        } as Fragment

        activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.category_list_container, fragment)
            ?.commit()
    }

    private fun handleBackButtonClick() {
        categoryBackButton.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.menu_fragment_container, SleepFragment())
                ?.commit()
        }
    }
}