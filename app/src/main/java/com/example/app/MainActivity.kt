package com.example.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityMainBinding
import com.example.app.principal.Principal

class MainActivity : AppCompatActivity() {
    private lateinit var views: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        views = ActivityMainBinding.inflate(layoutInflater)
        initializationListeners()
        setContentView(views.root)

    }

    private fun initializationListeners() {
        views.button.setOnClickListener {
            val userText = views.userInput.text.toString()
            val passwordText = views.passwordInput.text.toString()

            userText?.let {
                passwordText.let { itp ->
                    if (it.equals("edu") && itp.equals("1234"))
                        goToPrincipal(userText)
                }
            }
        }
    }

    private fun goToPrincipal(userText: String) {
        var intent = Intent(this, Principal::class.java)
        intent.putExtra("name_user", userText)
        startActivity(intent)
    }
}