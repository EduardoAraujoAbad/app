package com.example.app

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.app.databinding.ActivityMainBinding
import com.example.app.principal.Principal
import kotlin.math.absoluteValue
import kotlin.time.Duration.Companion.milliseconds

class MainActivity : AppCompatActivity() {
    private lateinit var views: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        views = ActivityMainBinding.inflate(layoutInflater)
        initializationListeners()
        setContentView(views.root)
        initializeAnimation()
        




    }

    private fun initializeAnimation() {
        val animationDrawable:AnimationDrawable=views.mainLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(resources.getInteger(R.integer.start_fade)) //resources.dimens
        animationDrawable.setExitFadeDuration(resources.getInteger(R.integer.end_fade))
        animationDrawable.start()
    }

    private fun initializationListeners() {
        views.button.setOnClickListener {
            val userText = views.userInput.text.toString()
            val passwordText = views.passwordInput.text.toString()

            userText?.let {
                passwordText.let { itp ->
                    if (it.equals("edu") && itp.equals("1234")) {
                        goToPrincipal(userText)
                    }else{
                        Toast.makeText(this, resources.getText(R.string.incorrect), Toast.LENGTH_SHORT).show()
                    }
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