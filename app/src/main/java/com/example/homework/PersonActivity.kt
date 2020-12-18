package com.example.homework

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PersonActivity : AppCompatActivity() {

    private lateinit var personInfoTextView: TextView
    private lateinit var paswordChanngeButton: Button
    private lateinit var logoutButton: Button

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        personInfoTextView = findViewById(R.id.personInfoTextView)
        paswordChanngeButton = findViewById(R.id.gotoPasswordChangeButton)
        logoutButton = findViewById(R.id.logoutButton)

        mAuth = FirebaseAuth.getInstance()

        personInfoTextView.text = mAuth.currentUser?.uid

        paswordChanngeButton.setOnClickListener {
            startActivity(Intent(this, PasswordChangeActivity::class.java))
        }

        logoutButton.setOnClickListener {
            mAuth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }
}