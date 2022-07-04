package com.appislami.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.appislami.Hadeth.HadethFragment
import com.appislami.R
import com.appislami.Radio.RadioFragment
import com.appislami.Tasbeh.TasbehFragment
import com.appislami.quran.quranFragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {

lateinit var BottomNavigation:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       BottomNavigation=findViewById(R.id.bottomNav)
       BottomNavigation.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener {MenuItem ->
           if (MenuItem.itemId == R.id.Quran)
           {pushFragment(quranFragment())
           }
           else if(MenuItem.itemId==R.id.Hadeth){
               pushFragment(HadethFragment())
           }else if(MenuItem.itemId==R.id.Tasbeh){
               pushFragment(TasbehFragment())}
           else {pushFragment(RadioFragment())}
           return@OnItemSelectedListener true;
       })
BottomNavigation.selectedItemId=R.id.Quran



    }


    private fun pushFragment(Fragment: Fragment) {
supportFragmentManager.beginTransaction().replace(R.id.fargmet_containrt,Fragment).addToBackStack("").commit()
    }
}