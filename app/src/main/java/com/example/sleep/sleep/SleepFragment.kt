package com.example.sleep.sleep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.sleep.R
import com.example.sleep.core.ListFragment

class SleepFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setListFragment()
        return inflater.inflate(R.layout.fragment_sleep, container, false)
    }

    private fun setListFragment() {
        val fragment = ListFragment.newInstance(categoryId = 0, trackId = 0)
       childFragmentManager.beginTransaction()
            .replace(R.id.list_container, fragment)
            .commit()
    }
}