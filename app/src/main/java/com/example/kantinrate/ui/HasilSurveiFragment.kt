package com.example.kantinrate.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.kantinrate.R

class HasilSurveiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_hasil_survei, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Bind clicks for the 5 respondent cards to show bottom sheet dialogs dynamically
        view.findViewById<View>(R.id.cardRespondenDevon)?.setOnClickListener {
            showDetails(
                name = "Devon",
                faculty = "Fakultas Ekonomi dan Bisnis",
                details = "Kantin FEB  •  Angkatan 2024",
                ratingKualitas = 4,
                ratingHarga = 4,
                comment = "Tempatnya luas, banyak varian menu, serta ramah di kantong mahasiswa."
            )
        }

        view.findViewById<View>(R.id.cardRespondenFelix)?.setOnClickListener {
            showDetails(
                name = "Felix",
                faculty = "Fakultas Teknik (POLIBAN)",
                details = "Kantin POLIBAN  •  Angkatan 2023",
                ratingKualitas = 5,
                ratingHarga = 5,
                comment = "Kantin bersih, parkiran luas, harga makanan bersahabat bagi mahasiswa politeknik."
            )
        }

        view.findViewById<View>(R.id.cardRespondenAhsan)?.setOnClickListener {
            showDetails(
                name = "Ahsan",
                faculty = "Fakultas Hukum",
                details = "Kantin FH  •  Angkatan 2024",
                ratingKualitas = 4,
                ratingHarga = 4,
                comment = "Menu bervariasi dari makanan berat hingga cemilan. Pelayanan ramah."
            )
        }

        view.findViewById<View>(R.id.cardRespondenNova)?.setOnClickListener {
            showDetails(
                name = "Nova",
                faculty = "Fakultas Ilmu Sosial dan Ilmu Politik",
                details = "Kantin SRC  •  Angkatan 2022",
                ratingKualitas = 4,
                ratingHarga = 4,
                comment = "Tempat strategis untuk nongkrong dan berdiskusi kelompok setelah kuliah selesai."
            )
        }

        view.findViewById<View>(R.id.cardRespondenAmin)?.setOnClickListener {
            showDetails(
                name = "Amin",
                faculty = "Fakultas Keguruan dan Ilmu Pendidikan",
                details = "Koperasi Tricivitas  •  Angkatan 2024",
                ratingKualitas = 5,
                ratingHarga = 5,
                comment = "Sangat puas dengan kebersihan kantin kopma. Pelayanan cepat dan tertata."
            )
        }
    }

    private fun showDetails(
        name: String,
        faculty: String,
        details: String,
        ratingKualitas: Int,
        ratingHarga: Int,
        comment: String
    ) {
        val bottomSheet = DetailRespondenBottomSheet.newInstance(
            name, faculty, details, ratingKualitas, ratingHarga, comment
        )
        bottomSheet.show(parentFragmentManager, "DetailRespondenBottomSheet")
    }
}
