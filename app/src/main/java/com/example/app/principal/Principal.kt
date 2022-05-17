package com.example.app.principal

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.AnimationDrawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.databinding.ActivityPrincipalBinding
import java.util.jar.Manifest

class Principal : AppCompatActivity() {
    private lateinit var views: ActivityPrincipalBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        views= ActivityPrincipalBinding.inflate(layoutInflater)
        setContentView(views.root)
        showName(intent)
        initializeAnimation()
        views.btnProfilepicture.setOnClickListener{ requestPermissions() }

    }

    private fun initializeAnimation() {

        val animationDrawable: AnimationDrawable =views.principalLayout.background as AnimationDrawable
        animationDrawable.setEnterFadeDuration(resources.getInteger(R.integer.start_fade))
        animationDrawable.setExitFadeDuration(resources.getInteger(R.integer.end_fade))
        animationDrawable.start()
    }

    private fun requestPermissions() {

        if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            when{
                ContextCompat.checkSelfPermission(
                   this,
                   android.Manifest.permission.READ_EXTERNAL_STORAGE
                )==PackageManager.PERMISSION_GRANTED ->{
                    pickPhotoFromGallery()
                }
                else -> requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)

            }
        }else{
            pickPhotoFromGallery()//mejorar logica
        }
    }

    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted->
        if (isGranted){
            pickPhotoFromGallery()
        }else{
            Toast.makeText(this,resources.getText(R.string.allow_permission),Toast.LENGTH_SHORT).show()
        }
    }

    private val startforActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){ result->
        if (result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data
            views.userImage.setImageURI(data)
        }
    }

    private fun pickPhotoFromGallery() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type="image/*"
        startforActivityGallery.launch(intent)

    }

    private fun showName(intent: Intent){
        val username = intent.getStringExtra("name_user")
        views.userInputPrincipal.setText(username)
    }
}