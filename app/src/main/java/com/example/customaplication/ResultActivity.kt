package com.example.customaplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.customaplication.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val userName: TextView = findViewById(R.id.textViewResultName)
        val btnFinish: Button = findViewById(R.id.buttonFinish)
        val textViewScore: TextView = findViewById(R.id.textViewScore)

        userName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        textViewScore.text = "Your score is $correctAnswers out of $totalQuestions"

        btnFinish.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))

        }


    }
}