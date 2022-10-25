package com.example.historypresentation.ui.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.historypresentation.R
import com.example.historypresentation.databinding.ActivityLoginBinding
import com.example.historypresentation.databinding.ActivityMainBinding
import com.example.historypresentation.ui.base.BaseActivity
import com.example.historypresentation.ui.main.fragment.MainFragment
import com.example.historypresentation.ui.main.fragment.QuizFragment
import com.example.historypresentation.ui.main.fragment.StudyFragment

class MainActivity : AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        supportFragmentManager.beginTransaction().add(R.id.fragment, StudyFragment()).commit()

        binding.bottomMenu.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom_main, MainFragment()).commit()
                }
                R.id.nav_study -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom_study, StudyFragment()).commit()
                }
                R.id.nav_test -> {
                    supportFragmentManager.beginTransaction().replace(R.id.layout_nav_bottom_quiz, QuizFragment()).commit()
                }
            }

            true
        }
    }
}