package com.example.historypresentation.ui.login

import android.content.ContentValues
import android.util.Log
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bumptech.glide.load.engine.Resource
import com.example.historypresentation.data.repository.LoginRepository
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    private val loginRepository = LoginRepository()

    private var auth: FirebaseAuth? = null
    val status = MutableLiveData<Boolean>(false)

    val idData = MutableLiveData("")
    val pwData = MutableLiveData("")

    fun login(){
        Log.d(ContentValues.TAG, "id : ${idData.value.toString()} , pw : ${pwData.value.toString()}")
        when(loginCompleteCheck(idData.value.toString(), pwData.value.toString())){
            false -> {
                Log.d(ContentValues.TAG, "Complete Check 완료")
                auth = FirebaseAuth.getInstance()

                auth?.signInWithEmailAndPassword(idData.value.toString(), idData.value.toString())
                    ?.addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Log.d(ContentValues.TAG, "Login 완료")
                            status.value = true
                        }
                        else{
                            status.value = false
                        }
                    }
            }

            true -> status.value = false
        }
    }

    private fun loginCompleteCheck(email: String, password: String): Boolean {
        return email.isBlank() || password.isBlank()
    }
}