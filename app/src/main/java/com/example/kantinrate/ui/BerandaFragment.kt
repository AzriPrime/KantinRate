package com.example.kantinrate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.fragment.findNavController
import androidx.navigation.navOptions
import com.example.kantinrate.R
import com.example.kantinrate.MainActivity

class BerandaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_beranda, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<View>(R.id.btnGaleri)?.setOnClickListener {
            navigateToTab(R.id.galeriFragment)
        }

        view.findViewById<View>(R.id.btnHasilSurvei)?.setOnClickListener {
            navigateToTab(R.id.hasilSurveiFragment)
        }
    }

    private fun navigateToTab(destinationId: Int) {
        (activity as? MainActivity)?.playBubbleSound()

        val options = navOptions {
            popUpTo(findNavController().graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }

        findNavController().navigate(destinationId, null, options)
    }
}
