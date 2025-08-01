package com.example.alarmapp

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MathChallengeActivity : AppCompatActivity() {

    private lateinit var correctAnswer : String
    private lateinit var  mediaPlayer : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_math_challenge)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mathQuestion = findViewById<TextView>(R.id.mathQuestion)
        val answer = findViewById<TextView>(R.id.answer)
        val submit = findViewById<TextView>(R.id.submit)

        mediaPlayer = MediaPlayer.create(this, R.raw.alarm_sound)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        val num1 = (1..20).random()
        val num2 = (1..20).random()
        correctAnswer = (num1 + num2).toString()
        mathQuestion.text = "What is $num1 + $num2 ?"

        submit.setOnClickListener(
            {
                if (answer.text.toString() == correctAnswer) {
                    mediaPlayer.stop()
                    Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
                    finish()
                } else {
                    Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show()
                }
            }
        )


    }
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()

    }
}