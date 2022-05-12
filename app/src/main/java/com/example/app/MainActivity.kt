package com.example.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var views: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        views = ActivityMainBinding.inflate(layoutInflater)
        initializationListeners()
        setContentView(views.root)

    }
    private fun initializationListeners(){
        views.button.setOnClickListener{
            Toast.makeText(this,"El usuario es:"+" "+ views.userInput.text+" "+"y su contrasena es"+" "+views.passwordInput.text, Toast.LENGTH_SHORT).show()
        }
    }
}