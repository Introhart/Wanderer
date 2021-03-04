package com.example.wanderer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationMenu : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu = findViewById(R.id.bottom_nav);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

    }



    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.page_explore -> {
                Toast.makeText(applicationContext, "Explore", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.page_map -> {
                Toast.makeText(applicationContext, "Map", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MapActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.page_profile -> {
                Toast.makeText(applicationContext, "Profile", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}