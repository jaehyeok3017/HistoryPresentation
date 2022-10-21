package com.example.historypresentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.historypresentation.data.repository.LoginRepository

class LoginViewModel : ViewModel() {
    private val loginRepository = LoginRepository()

    lateinit var idData : LiveData<String>
    lateinit var pwData : LiveData<String>
}