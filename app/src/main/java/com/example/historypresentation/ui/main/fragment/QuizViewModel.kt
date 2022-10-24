package com.example.historypresentation.ui.main.fragment

import android.content.ContentValues.TAG
import android.graphics.Insets.add
import android.text.method.TextKeyListener.clear
import android.util.Log
import androidx.core.graphics.Insets.add
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.historypresentation.data.model.QuizData
import com.google.firebase.database.core.RepoManager.clear
import com.google.firebase.firestore.FirebaseFirestore

class QuizViewModel : ViewModel() {
    private var firestore: FirebaseFirestore? = FirebaseFirestore.getInstance()
    var quizNum = 0

    private val _quizName = MutableLiveData<String>("")
    val quizName: LiveData<String> get() = _quizName

    private val _quizChoice1 = MutableLiveData<String>("")
    val quizChoice1: LiveData<String> get() = _quizChoice1

    private val _quizChoice2 = MutableLiveData<String>("")
    val quizChoice2: LiveData<String> get() = _quizChoice2

    private val _quizChoice3 = MutableLiveData<String>("")
    val quizChoice3: LiveData<String> get() = _quizChoice3

    private val _quizChoice4 = MutableLiveData<String>("")
    val quizChoice4: LiveData<String> get() = _quizChoice4

    private val _quizChoice5 = MutableLiveData<String>("")
    val quizChoice5: LiveData<String> get() = _quizChoice5


//    init {
//        firestore?.collection("quiz")?.addSnapshotListener { querySnapshot, firebaseFirestoreException ->
//            QuizData.clear()
//            if (querySnapshot == null) return@addSnapshotListener
//
//            for (snapshot in querySnapshot!!.documents) {
//                var item = snapshot.toObject(QuizData::class.java)
//                QuizData.add(item!!)
//            }
//            notifyDataSetChanged()
//        }
//    }
}