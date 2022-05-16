package com.example.app.principal

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import androidx.constraintlayout.widget.ConstraintLayout
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

        val constraintLayout = findViewById<ConstraintLayout>(R.id.principal_layout)
        val animationDrawable: AnimationDrawable =constraintLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(2000)
        animationDrawable.setExitFadeDuration(4000)
        animationDrawable.start()


    }
    private fun showName(intent: Intent){
        val username = intent.getStringExtra("name_user")
        views.userInputPrincipal.setText(username)
    }
}