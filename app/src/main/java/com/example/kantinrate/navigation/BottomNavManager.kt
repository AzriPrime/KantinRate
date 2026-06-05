package com.example.kantinrate.navigation

import android.content.res.ColorStateList
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.navOptions
import com.example.kantinrate.MainActivity
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
        val options = navOptions {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        navHome.setOnClickListener {
            playClickSound()
            if (navController.currentDestination?.id != R.id.berandaFragment) {
                navController.navigate(R.id.berandaFragment, null, options)
            }
        }

        navGallery.setOnClickListener {
            playClickSound()
            if (navController.currentDestination?.id != R.id.galeriFragment) {
                navController.navigate(R.id.galeriFragment, null, options)
            }
        }

        navResults.setOnClickListener {
            playClickSound()
            if (navController.currentDestination?.id != R.id.hasilSurveiFragment) {
                navController.navigate(R.id.hasilSurveiFragment, null, options)
            }
        }
    }

    private fun playClickSound() {
        (navigationContainer.context as? MainActivity)?.playBubbleSound()
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

        resetTab(imgNavHome, txtNavHome, grayColor)
        resetTab(imgNavGallery, txtNavGallery, grayColor, frameNavGallery)
        resetTab(imgNavResults, txtNavResults, grayColor, frameNavResults)

        when (destinationId) {
            R.id.berandaFragment -> {
                setActiveTab(imgNavHome, txtNavHome, greenColor)
            }
            R.id.galeriFragment -> {
                setActiveTab(imgNavGallery, txtNavGallery, greenColor)
            }
            R.id.hasilSurveiFragment -> {
                frameNavResults.background = ContextCompat.getDrawable(context, R.drawable.bg_rounded_badge_green)
                val density = context.resources.displayMetrics.density
                val pxH = (16 * density).toInt()
                val pxV = (2 * density).toInt()
                frameNavResults.setPadding(pxH, pxV, pxH, pxV)

                setActiveTab(imgNavResults, txtNavResults, greenColor)
            }
        }
    }

    private fun resetTab(img: ImageView, txt: TextView, color: Int, frame: FrameLayout? = null) {
        img.imageTintList = ColorStateList.valueOf(color)
        txt.setTextColor(color)
        txt.setTypeface(null, android.graphics.Typeface.NORMAL)
        frame?.let {
            it.background = null
            it.setPadding(0, 0, 0, 0)
        }
    }

    private fun setActiveTab(img: ImageView, txt: TextView, color: Int) {
        img.imageTintList = ColorStateList.valueOf(color)
        txt.setTextColor(color)
        txt.setTypeface(null, android.graphics.Typeface.BOLD)
    }
}