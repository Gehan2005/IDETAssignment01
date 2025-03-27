package com.example.assignment01

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import com.example.assignment01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nextButton: Button = binding.nextbtn
        nextButton.setOnClickListener {
            val intent = Intent(this, activity_main_next2::class.java) // Correct class name
            startActivity(intent)
        }
    }
}
