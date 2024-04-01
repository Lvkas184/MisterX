package com.lukas.misterx

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.lukas.misterx.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var button1: Button
    private lateinit var button2: Button

    companion object {
        var gamePin: String? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)

        button1.setOnClickListener {
            val intent = Intent(this, CreateNewGameActivity::class.java)
           gamePin = Random.nextInt(1000, 9999).toString()
            startActivity(intent)
        }
        button2.setOnClickListener {
            val intent = Intent(this, JoinGameActivity::class.java)
            startActivity(intent)
        }
    }
}