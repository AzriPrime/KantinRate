package com.example.kantinrate

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.kantinrate.navigation.BottomNavManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve NavController from NavHostFragment
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Find the included bottom navigation container view
        val navigationContainer = findViewById<View>(R.id.bottomNavigationInclude)

        // Initialize the separated Bottom Navigation Manager to handle all navigation actions and styling
        BottomNavManager(navigationContainer, navController)
    }
}