package com.example.historypresentation.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.historypresentation.data.repository.LoginRepository

class LoginViewModel : ViewModel() {
    private val loginRepository = LoginRepository()

    private val _idData = MutableLiveData<String>("id")
    val idData : LiveData<String> get() = _idData

    private val _pwData = MutableLiveData<String>("pw")
    val pwData : LiveData<String> get() = _pwData
}