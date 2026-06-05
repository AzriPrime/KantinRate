package com.example.kantinrate

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.media.SoundPool
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.kantinrate.navigation.BottomNavManager

class MainActivity : AppCompatActivity() {

    private var soundPool: SoundPool? = null
    private var bubbleSoundId: Int = 0
    private var closeSoundId: Int = 0
    private var bgMediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bgMediaPlayer = MediaPlayer.create(this, R.raw.bg_music)
        bgMediaPlayer?.isLooping = true
        bgMediaPlayer?.setVolume(1f, 1f)
        bgMediaPlayer?.start()

        val audioAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
            .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
            .build()

        soundPool = SoundPool.Builder()
            .setMaxStreams(5)
            .setAudioAttributes(audioAttributes)
            .build()

        bubbleSoundId = soundPool?.load(this, R.raw.bubble_click, 1) ?: 0
        closeSoundId = soundPool?.load(this, R.raw.close_click, 1) ?: 0

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        val navController = navHostFragment.navController

        val navigationContainer = findViewById<View>(R.id.bottomNavigationInclude)

        BottomNavManager(navigationContainer, navController)
    }

    fun playBubbleSound() {
        if (bubbleSoundId != 0) {
            soundPool?.play(bubbleSoundId, 1.0f, 1.0f, 0, 0, 1f)
        }
    }

    fun playCloseSound() {
        if (closeSoundId != 0) {
            soundPool?.play(closeSoundId, 1.0f, 1.0f, 0, 0, 1f)
        }
    }

    override fun onResume() {
        super.onResume()
        bgMediaPlayer?.start()
    }

    override fun onPause() {
        super.onPause()
        bgMediaPlayer?.pause()
    }

    override fun onDestroy() {
        super.onDestroy()
        soundPool?.release()
        soundPool = null
        
        bgMediaPlayer?.stop()
        bgMediaPlayer?.release()
        bgMediaPlayer = null
    }
}
