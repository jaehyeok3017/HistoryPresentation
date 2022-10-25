package com.example.historypresentation.ui.main.fragment

import android.content.ContentValues
import android.content.ContentValues.TAG
import android.text.method.TextKeyListener.clear
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.historypresentation.data.model.QuizData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.core.RepoManager.clear
import com.google.firebase.firestore.FirebaseFirestore

class QuizViewModel : ViewModel() {
    private var db : FirebaseFirestore = FirebaseFirestore.getInstance()
    private var auth : FirebaseAuth = FirebaseAuth.getInstance()
    private val quizData : ArrayList<QuizData> = arrayListOf()

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

    fun quizCollectionSet() {
        db.collection("quiz")
            .addSnapshotListener { querySnapshot, firebaseFirestoreException ->
                quizData.clear()
                if (querySnapshot == null) {
                    Log.d(TAG, "Query Snapshot이 비어있습니다")
                }

                else {
                    for (snapshot in querySnapshot.documents) {
                        val item = snapshot.toObject(QuizData::class.java)
                        Log.d(TAG, "{$item}")
                        quizData.add(item!!)
                    }
                }
            }
    }

    fun quizDataSelect(documentId : Int) {
        if(documentId < 7){
            _quizName.value = quizData[documentId].quizName
            _quizChoice1.value = quizData[documentId].quizMultipleChoice1
            _quizChoice2.value = quizData[documentId].quizMultipleChoice2
            _quizChoice3.value = quizData[documentId].quizMultipleChoice3
            _quizChoice4.value = quizData[documentId].quizMultipleChoice4
            _quizChoice5.value = quizData[documentId].quizMultipleChoice5
        }
    }

    fun quizDataUpload(sum : Int){

    }
}