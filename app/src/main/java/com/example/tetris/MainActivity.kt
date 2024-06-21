package com.example.tetris

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBtn:Button = findViewById(R.id.play_btn)

        playBtn.setOnClickListener {
            try {
                startActivity(Intent(this,Game::class.java))
            }catch (e: Exception){
                e.printStackTrace()
            }

        }


    }
}