package com.example.kantinrate.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.kantinrate.MainActivity
import com.example.kantinrate.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.button.MaterialButton

class DetailRespondenBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_detail_responden, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = arguments?.getString(ARG_NAME) ?: ""
        val faculty = arguments?.getString(ARG_FACULTY) ?: ""
        val details = arguments?.getString(ARG_DETAILS) ?: ""
        val ratingKualitas = arguments?.getInt(ARG_RATING_KUALITAS) ?: 4
        val ratingHarga = arguments?.getInt(ARG_RATING_HARGA) ?: 4
        val comment = arguments?.getString(ARG_COMMENT) ?: ""

        view.findViewById<TextView>(R.id.txtDetailName)?.text = name
        view.findViewById<TextView>(R.id.txtDetailFaculty)?.text = faculty
        view.findViewById<TextView>(R.id.txtDetailInfo)?.text = details

        view.findViewById<TextView>(R.id.txtRatingKualitasValue)?.text = "$ratingKualitas/5"
        view.findViewById<TextView>(R.id.txtRatingHargaValue)?.text = "$ratingHarga/5"

        view.findViewById<TextView>(R.id.txtDetailComment)?.text = "\"$comment\""

        val imgStarK5 = view.findViewById<ImageView>(R.id.imgStarK5)
        if (ratingKualitas >= 5) {
            imgStarK5?.setImageResource(R.drawable.ic_star_filled)
        } else {
            imgStarK5?.setImageResource(R.drawable.ic_star_outline)
        }

        val imgStarH5 = view.findViewById<ImageView>(R.id.imgStarH5)
        if (ratingHarga >= 5) {
            imgStarH5?.setImageResource(R.drawable.ic_star_filled)
        } else {
            imgStarH5?.setImageResource(R.drawable.ic_star_outline)
        }

        view.findViewById<View>(R.id.btnCloseDialog)?.setOnClickListener {
            (activity as? MainActivity)?.playCloseSound()
            dismiss()
        }

        view.findViewById<MaterialButton>(R.id.btnTutupDialog)?.setOnClickListener {
            (activity as? MainActivity)?.playCloseSound()
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        (view?.parent as? View)?.setBackgroundColor(Color.TRANSPARENT)
    }

    companion object {
        private const val ARG_NAME = "arg_name"
        private const val ARG_FACULTY = "arg_faculty"
        private const val ARG_DETAILS = "arg_details"
        private const val ARG_RATING_KUALITAS = "arg_rating_kualitas"
        private const val ARG_RATING_HARGA = "arg_rating_harga"
        private const val ARG_COMMENT = "arg_comment"

        fun newInstance(
            name: String,
            faculty: String,
            details: String,
            ratingKualitas: Int,
            ratingHarga: Int,
            comment: String
        ): DetailRespondenBottomSheet {
            val fragment = DetailRespondenBottomSheet()
            val args = Bundle().apply {
                putString(ARG_NAME, name)
                putString(ARG_FACULTY, faculty)
                putString(ARG_DETAILS, details)
                putInt(ARG_RATING_KUALITAS, ratingKualitas)
                putInt(ARG_RATING_HARGA, ratingHarga)
                putString(ARG_COMMENT, comment)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
