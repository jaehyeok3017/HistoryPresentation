package com.example.historypresentation.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.historypresentation.R
import com.example.historypresentation.databinding.FragmentMainBinding
import com.example.historypresentation.ui.base.BaseFragment

class MainFragment : BaseFragment<FragmentMainBinding>(R.layout.fragment_main) {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_main, container, false)

        return binding.root
    }

    override fun init() {

    }
}