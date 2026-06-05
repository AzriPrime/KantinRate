package com.example.kantinrate.navigation

import android.content.res.ColorStateList
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.example.kantinrate.R

class BottomNavManager(
    private val navigationContainer: View,
    private val navController: NavController
) {
    private val navHome: View = navigationContainer.findViewById(R.id.navHome)
    private val navGallery: View = navigationContainer.findViewById(R.id.navGallery)
    private val navResults: View = navigationContainer.findViewById(R.id.navResults)

    private val imgNavHome: ImageView = navigationContainer.findViewById(R.id.imgNavHome)
    private val txtNavHome: TextView = navigationContainer.findViewById(R.id.txtNavHome)
    private val imgNavGallery: ImageView = navigationContainer.findViewById(R.id.imgNavGallery)
    private val txtNavGallery: TextView = navigationContainer.findViewById(R.id.txtNavGallery)
    private val imgNavResults: ImageView = navigationContainer.findViewById(R.id.imgNavResults)
    private val txtNavResults: TextView = navigationContainer.findViewById(R.id.txtNavResults)

    private val frameNavGallery: FrameLayout = navigationContainer.findViewById(R.id.frameNavGallery)
    private val frameNavResults: FrameLayout = navigationContainer.findViewById(R.id.frameNavResults)

    init {
        setupClickListeners()
        setupDestinationListener()
    }

    private fun setupClickListeners() {
        navHome.setOnClickListener {
            navController.navigate(R.id.berandaFragment) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }

        navGallery.setOnClickListener {
            navController.navigate(R.id.galeriFragment) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }

        navResults.setOnClickListener {
            navController.navigate(R.id.hasilSurveiFragment) {
                popUpTo(navController.graph.startDestinationId) { saveState = true }
                launchSingleTop = true
                restoreState = true
            }
        }
    }

    private fun setupDestinationListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            updateBottomNavSelection(destination.id)
        }
    }

    private fun updateBottomNavSelection(destinationId: Int) {
        val context = navigationContainer.context
        val greenColor = ContextCompat.getColor(context, R.color.primary_green)
        val grayColor = ContextCompat.getColor(context, R.color.text_gray)

        // Reset all tabs to inactive state
        imgNavHome.imageTintList = ColorStateList.valueOf(grayColor)
        txtNavHome.setTextColor(grayColor)
        txtNavHome.setTypeface(null, android.graphics.Typeface.NORMAL)

        imgNavGallery.imageTintList = ColorStateList.valueOf(grayColor)
        txtNavGallery.setTextColor(grayColor)
        txtNavGallery.setTypeface(null, android.graphics.Typeface.NORMAL)
        frameNavGallery.background = null
        frameNavGallery.setPadding(0, 0, 0, 0)

        imgNavResults.imageTintList = ColorStateList.valueOf(grayColor)
        txtNavResults.setTextColor(grayColor)
        txtNavResults.setTypeface(null, android.graphics.Typeface.NORMAL)
        frameNavResults.background = null
        frameNavResults.setPadding(0, 0, 0, 0)

        // Apply active styles to the selected tab destination
        when (destinationId) {
            R.id.berandaFragment -> {
                imgNavHome.imageTintList = ColorStateList.valueOf(greenColor)
                txtNavHome.setTextColor(greenColor)
                txtNavHome.setTypeface(null, android.graphics.Typeface.BOLD)
            }
            R.id.galeriFragment -> {
                imgNavGallery.imageTintList = ColorStateList.valueOf(greenColor)
                txtNavGallery.setTextColor(greenColor)
                txtNavGallery.setTypeface(null, android.graphics.Typeface.BOLD)
            }
            R.id.hasilSurveiFragment -> {
                // Apply pill background highlight on Hasil Survei tab active (to match mockup exactly)
                frameNavResults.background = ContextCompat.getDrawable(context, R.drawable.bg_rounded_badge_green)
                val density = context.resources.displayMetrics.density
                val pxHorizontal = (16 * density).toInt()
                val pxVertical = (2 * density).toInt()
                frameNavResults.setPadding(pxHorizontal, pxVertical, pxHorizontal, pxVertical)

                imgNavResults.imageTintList = ColorStateList.valueOf(greenColor)
                txtNavResults.setTextColor(greenColor)
                txtNavResults.setTypeface(null, android.graphics.Typeface.BOLD)
            }
        }
    }
}
