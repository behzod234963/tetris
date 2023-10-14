package com.coder.behzod.tetris.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.coder.behzod.tetris.R
import com.coder.behzod.tetris.databinding.ActivityGameBinding
import com.coder.behzod.tetris.storage.sharedPrefernces.AppPreferences

class GameActivity : AppCompatActivity() {

    lateinit var binding: ActivityGameBinding
    var preferences = AppPreferences(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainController()

    }

    private fun mainController() {

        updateHighScore()
        updateCurrentScore()
        listeners()

    }

    private fun listeners() {

    }

    fun updateHighScore() {
        binding.tvHighScore.text = "${preferences.getHighScore()}"
    }

    fun updateCurrentScore() {
        binding.tvCurrentScore.text = "0"
    }

}