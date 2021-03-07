package com.example.wanderer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.*
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationMenu : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.supportActionBar?.hide()

        bottomNavigationMenu = findViewById(R.id.bottom_nav);
        bottomNavigationMenu.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<ExploreFragment>(R.id.fragment_container_view)
        }
    }




    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.page_explore -> {
//                Toast.makeText(applicationContext, "Explore", Toast.LENGTH_SHORT).show()
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<ExploreFragment>(R.id.fragment_container_view)
                }
                return@OnNavigationItemSelectedListener true
            }
            R.id.page_map -> {
//                Toast.makeText(applicationContext, "Map", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MapActivity::class.java)
                startActivity(intent)
                return@OnNavigationItemSelectedListener true
            }
            R.id.page_profile -> {
                supportFragmentManager.commit {
                    setReorderingAllowed(true)
                    replace<ProfileFragment>(R.id.fragment_container_view)
                }
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
}
