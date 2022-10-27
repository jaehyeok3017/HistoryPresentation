package com.example.historypresentation.ui.main.fragment

import android.annotation.SuppressLint
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import com.example.historypresentation.R
import com.example.historypresentation.databinding.ActivityMainBinding
import com.example.historypresentation.databinding.FragmentMainBinding
import com.example.historypresentation.databinding.FragmentQuizBinding
import com.example.historypresentation.databinding.FragmentStudyBinding
import com.example.historypresentation.ui.base.BaseFragment

class StudyFragment : BaseFragment<FragmentStudyBinding>(R.layout.fragment_study) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_study, container, false)

        binding.scrollHorizontal.isHorizontalScrollBarEnabled = true
        binding.scrollHorizontal.isVerticalScrollBarEnabled = true

        binding.scrollHorizontal2.isHorizontalScrollBarEnabled = true
        binding.scrollHorizontal2.isVerticalScrollBarEnabled = true

//        binding.yearChange.setOnClickListener {
//            binding.yearImage.setImageResource(R.drawable.history2)
//        }

        return binding.root
    }

}