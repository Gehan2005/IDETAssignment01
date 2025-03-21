package com.example.assignment01

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.assignment01.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val editText1 = findViewById<EditText>(R.id.editText1) // Name
        val editText2 = findViewById<EditText>(R.id.editText2) // Age
        val editText3 = findViewById<EditText>(R.id.editText3) // Email
        val radioButton1 = findViewById<RadioButton>(R.id.radioButton1) // Male
        val radioButton2 = findViewById<RadioButton>(R.id.radioButton2) // Female
        val spinner = findViewById<Spinner>(R.id.spinner) // Country
        val checkBox = findViewById<CheckBox>(R.id.checkBox) // Agree Terms
        val submitButton = findViewById<Button>(R.id.submitButton)
        val textView = findViewById<TextView>(R.id.textView)
        val buttonBack = findViewById<Button>(R.id.buttonBack)

        // Spinner Items
        val options = arrayOf("Sri Lanka", "India", "United States")
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = spinnerAdapter

        submitButton.setOnClickListener {
            val name = editText1.text.toString().trim()
            val ageText = editText2.text.toString().trim()
            val email = editText3.text.toString().trim()

            // Validation
            if (name.isEmpty()) {
                editText1.error = "Name is required"
                return@setOnClickListener
            }

            if (ageText.isEmpty()) {
                editText2.error = "Age is required"
                return@setOnClickListener
            }

            val age = ageText.toIntOrNull()
            if (age == null || age <= 0) {
                editText2.error = "Enter a valid age"
                return@setOnClickListener
            }

            if (email.isEmpty()) {
                editText3.error = "Email is required"
                return@setOnClickListener
            }

            if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                editText3.error = "Enter a valid email"
                return@setOnClickListener
            }

            // Ensure a gender is selected
            val gender = when {
                radioButton1.isChecked -> "Male"
                radioButton2.isChecked -> "Female"
                else -> {
                    Toast.makeText(this, "Please select gender", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }

            // Ensure the user agrees to terms
            if (!checkBox.isChecked) {
                Toast.makeText(this, "You must agree to the terms", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Get selected country
            val selectedCountry = spinner.selectedItem.toString()

            // Display data in TextView
            val message = """
                Name: $name
                Age: $age
                Email: $email
                Gender: $gender
                Country: $selectedCountry
            """.trimIndent()

            textView.text = message
        }

        buttonBack.setOnClickListener {
            finish() // Go back to the previous activity
        }
    }
}
