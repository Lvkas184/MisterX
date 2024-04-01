package com.lukas.misterx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class JoinGameActivity : AppCompatActivity() {

    lateinit var editTextGamePin: EditText
    lateinit var joinButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_join_game)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val backButton: Button = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }

        editTextGamePin = findViewById(R.id.editTextGamePin)
        joinButton = findViewById(R.id.joinButton)

        joinButton.setOnClickListener {
            val enteredPin = editTextGamePin.text.toString()
            if (enteredPin == MainActivity.gamePin) {
                val intent = Intent(this, CreateNewGameActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Falscher Spiel-Pin eingegeben", Toast.LENGTH_SHORT).show()
            }
        }

    }
}