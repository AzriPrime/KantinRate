package com.example.kantinrate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.kantinrate.R

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

        // Navigation from dashboard buttons using Jetpack Navigation
        view.findViewById<View>(R.id.btnGaleri)?.setOnClickListener {
            findNavController().navigate(R.id.galeriFragment)
        }

        view.findViewById<View>(R.id.btnHasilSurvei)?.setOnClickListener {
            findNavController().navigate(R.id.hasilSurveiFragment)
        }
    }
}
