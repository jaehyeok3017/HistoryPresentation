package com.example.historypresentation.ui.login

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.viewModelScope
import com.example.historypresentation.ui.register.RegisterActivity
import com.example.historypresentation.databinding.ActivityLoginBinding
import com.example.historypresentation.ui.main.MainActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    val viewModel : LoginViewModel by viewModels()
    var auth: FirebaseAuth? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        auth = FirebaseAuth.getInstance()
        binding.loginbtn.setOnClickListener {
            viewModel.login()

            viewModel.viewModelScope.launch{
                when(viewModel.status.value){
                    true -> {
                        moveMainPage(auth?.currentUser)
                    }

                    else -> Toast.makeText(this@LoginActivity, "로그인에 실패했습니다.", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.registerbtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    override fun onStart(){
        super.onStart()
        moveMainPage(auth?.currentUser)
    }

    private fun moveMainPage(user: FirebaseUser?){
        if(user != null) {
            Toast.makeText(this, "로그인이 완료되었습니다!", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}