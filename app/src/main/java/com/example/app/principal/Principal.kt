package com.example.app.principal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.databinding.ActivityPrincipalBinding

class Principal : AppCompatActivity() {
    private lateinit var views: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views= ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(views.root)
        showName(intent)
    }
    private fun showName(intent: Intent){
        val username = intent.getStringExtra("name_user")
        views.userInputPrincipal.setText(username)
    }
}