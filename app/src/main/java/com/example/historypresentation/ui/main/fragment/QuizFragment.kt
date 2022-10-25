package com.example.historypresentation.ui.main.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.lifecycle.ViewModelProvider
import com.example.historypresentation.R
import com.example.historypresentation.databinding.FragmentMainBinding
import com.example.historypresentation.databinding.FragmentQuizBinding
import com.example.historypresentation.ui.base.BaseFragment
import com.example.historypresentation.ui.login.LoginViewModel

class QuizFragment : BaseFragment<FragmentQuizBinding>(R.layout.fragment_quiz) {
    lateinit var quizViewModel: QuizViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_quiz, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        quizViewModel = ViewModelProvider(this)[QuizViewModel::class.java]
        quizViewModel.quizCollectionSet()

        var quizCount : Int = 0
        var sum = 0

        if(quizCount < 7){
            binding.choice1.setOnClickListener {
                quizViewModel.quizDataSelect(quizCount)
                quizCount += 1
            }

            binding.choice2.setOnClickListener {
                quizViewModel.quizDataSelect(quizCount)
                quizCount += 1
            }

            binding.choice3.setOnClickListener {
                quizViewModel.quizDataSelect(quizCount)
                quizCount += 1
            }

            binding.choice4.setOnClickListener {
                quizViewModel.quizDataSelect(quizCount)
                quizCount += 1
            }

            binding.choice5.setOnClickListener {
                quizViewModel.quizDataSelect(quizCount)
                quizCount += 1
                sum += 10
            }
        }

        else{

        }
    }

    override fun init() {

    }
}