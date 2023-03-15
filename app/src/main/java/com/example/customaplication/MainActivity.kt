package com.example.customaplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name: EditText = findViewById(R.id.textViewName)
        val password: EditText = findViewById(R.id.textViewPassword)
        val button: Button = findViewById(R.id.textViewButton)


        button.setOnClickListener {

            val user = name.text.toString()
            val userPassword = password.text.toString()

            if (user.isNotEmpty() && userPassword.isEmpty()) {
                Toast.makeText(this, "Please enter your password", Toast.LENGTH_LONG).show()
            } else if (user.isEmpty() && userPassword.isNotEmpty()) {
                Toast.makeText(this, "Please enter your username", Toast.LENGTH_LONG).show()
            } else if (user.isEmpty() && userPassword.isEmpty()) {
                Toast.makeText(this, "Please enter your username and password", Toast.LENGTH_LONG)
                    .show()
            } else {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(Constants.USER_NAME, name.text.toString())
                startActivity(intent)
                finish()
            }

        }
    }
}