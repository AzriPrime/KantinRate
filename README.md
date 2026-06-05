# KantinRate ULM 🍽️⭐

Aplikasi Android berbasis Native XML (Kotlin) untuk menampilkan visualisasi dokumentasi dan survei kepuasan mahasiswa terhadap variasi menu kantin di lingkungan Universitas Lambung Mangkurat (ULM). 

Aplikasi ini menggunakan arsitektur **Single-Activity + Fragments** yang efisien serta mengimplementasikan pedoman desain **Material Components** (Material 3 & Material Design 2) untuk antarmuka yang modern dan responsif.

---

## ✨ Fitur Utama
1. **Beranda**: Dashboard utama yang menampilkan logo ULM (vector), informasi proyek, serta jalan pintas navigasi ke fitur Galeri dan Hasil Survei.
2. **Galeri & Dokumentasi**: Grid dua kolom yang menampilkan foto dokumentasi kantin tiap fakultas beserta dokumentasi bersama responden.
3. **Hasil Survei**: Daftar responden dari 5 fakultas berbeda lengkap dengan rating bintang rata-rata yang mereka berikan.
4. **Detail Responden (BottomSheet Dialog)**: Popup interaktif yang muncul ketika salah satu responden diklik, menampilkan detail kepuasan (kualitas makanan & harga) beserta kutipan langsung ulasan responden secara dinamis.

---

## 🛠️ Tech Stack & Library
* **Language**: Kotlin
* **UI Framework**: Android XML Views (ConstraintLayout, LinearLayout, FrameLayout)
* **Styling**: Google Material Components (`MaterialCardView`, `MaterialButton` dengan sudut membulat kustom & shadow elevation)
* **Navigation**: Android Jetpack Navigation Component (menggunakan `nav_graph.xml` untuk perpindahan antar fragment secara instan dan aman)
* **Minimum SDK**: Android 7.0 (API 24)
* **Target SDK**: Android 14 (API 36)

---

## 📂 Struktur Direktori Utama
```text
KantinRate/
├── app/
│   ├── src/main/
│   │   ├── java/com/example/kantinrate/
│   │   │   ├── MainActivity.kt        # Activity Tunggal (Host)
│   │   │   ├── navigation/
│   │   │   │   └── BottomNavManager.kt # Pengelola modular event/style navbar bawah
│   │   │   └── ui/
│   │   │       ├── BerandaFragment.kt  # Logika halaman Beranda
│   │   │       ├── GaleriFragment.kt   # Logika halaman Galeri
│   │   │       ├── HasilSurveiFragment.kt # Logika daftar responden survei
│   │   │       └── DetailRespondenBottomSheet.kt # Dialog detail responden
│   │   └── res/
│   │       ├── layout/                  # Berkas tata letak XML
│   │       │   ├── activity_main.xml    # Container utama
│   │       │   ├── layout_bottom_nav.xml # Layout Bottom Nav modular
│   │       │   ├── activity_beranda.xml
│   │       │   ├── activity_galeri.xml
│   │       │   ├── activity_hasil_survei.xml
│   │       │   └── dialog_detail_responden.xml
│   │       ├── navigation/
│   │       │   └── nav_graph.xml        # Definisi alur navigasi Jetpack
│   │       └── drawable/                # Aset ikon vector & logo ULM
```

---

## 🚀 Cara Menjalankan Proyek
1. Clone repositori ini ke komputer lokal Anda:
   ```bash
   git clone https://github.com/AzriPrime/KantinRate.git
   ```
2. Buka aplikasi **Android Studio**.
3. Pilih **File > Open**, lalu pilih folder `KantinRate`.
4. Tunggu hingga proses sinkronisasi **Gradle** selesai secara otomatis.
5. Hubungkan perangkat Android fisik atau aktifkan Emulator Android.
6. Klik tombol **Run (Run 'app')** berwarna hijau di bilah menu atas Android Studio.

---

## 🎨 Best Practices yang Diterapkan
* **Single Responsibility Principle**: Pemisahan logika UI Bottom Navigation sepenuhnya didelegasikan kepada `BottomNavManager` untuk menjaga `MainActivity` tetap ringkas.
* **Loose Coupling**: Setiap fragment memicu perpindahan layar menggunakan `findNavController()` secara mandiri tanpa ketergantungan langsung ke kelas Activity.
* **Optimal Visual Rendering**: Menggunakan background transparan programatis pada BottomSheet untuk menghilangkan sisa bingkai putih di belakang sudut membulat card dialog.
