package com.example.assignment01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.widget.Button

class activity_main_next2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_next2)

        // Load HomeFragment by default
        loadFragment(HomeFragment())

        // Find buttons by ID
        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnChat = findViewById<Button>(R.id.btnChat)
        val btnSettings = findViewById<Button>(R.id.btnSettings)

        // Set click listeners for each button
        btnHome.setOnClickListener {
            loadFragment(HomeFragment()) // Load Home Fragment on click
        }

        btnChat.setOnClickListener {
            loadFragment(ChatFragment()) // Load Chat Fragment on click
        }

        btnSettings.setOnClickListener {
            loadFragment(SettingFragment()) // Load Settings Fragment on click
        }
    }

    // Function to replace fragment
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}
