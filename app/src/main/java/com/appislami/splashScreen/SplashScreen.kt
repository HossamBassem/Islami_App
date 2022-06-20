package com.appislami.splashScreen

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.appcompat.app.AppCompatActivity
import com.appislami.MainActivity
import com.appislami.R

class SplashScreen :AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        Handler(Looper.getMainLooper())
            .postDelayed( { startHomeActivity() },2000)
    }
    fun startHomeActivity(){
        val intent = Intent( this, MainActivity::class.java)
        startActivity(intent)
        finish()


    }
}