package com.appislami

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.appislami.mainActivity.MainActivity
import android.content.Intent as Intent

class SplashScreen:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash)
        Handler(Looper.getMainLooper())
            .postDelayed({StartActivity()},2000)
    }
fun StartActivity(){
   val intent= Intent(this,MainActivity::class.java)
    startActivity(intent)
    finish()

}
}