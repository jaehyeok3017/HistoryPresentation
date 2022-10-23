package com.example.historypresentation.ui.login

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.historypresentation.data.repository.LoginRepository
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    private val loginRepository = LoginRepository()

    private var auth: FirebaseAuth? = null
    val status = MutableLiveData<Boolean>(false)
    val failReason = MutableLiveData<String>()

    private val _idData = MutableLiveData<String>()
    val idData : LiveData<String> get() = _idData

    private val _pwData = MutableLiveData<String>()
    val pwData : LiveData<String> get() = _pwData

    fun login(){
        when(loginCompleteCheck(idData.toString(), pwData.toString())){
            false -> {
                auth = FirebaseAuth.getInstance()

                auth?.signInWithEmailAndPassword(idData.toString(), pwData.toString())
                    ?.addOnCompleteListener { task ->
                        status.value = task.isSuccessful
                    }
            }

            true -> status.value = false
        }
    }

    private fun loginCompleteCheck(email: String, password: String): Boolean {
        return email.isBlank() && password.isBlank()
    }
}