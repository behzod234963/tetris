package com.coder.behzod.tetris.ui

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.coder.behzod.tetris.R
import com.coder.behzod.tetris.databinding.ActivityMainBinding
import com.coder.behzod.tetris.storage.sharedPrefernces.AppPreferences

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainController()

    }

    private fun mainController() {

        listeners()

    }

    private fun listeners() {
        binding.apply {
            btnNewGame.setOnClickListener { onBtnNewGame() }
            btnResetScore.setOnClickListener { onBtnResetScore() }
            btnExit.setOnClickListener { onBtnExit() }
        }
    }

    private fun onBtnResetScore() {
        setDialog()
    }

    private fun setDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_item)
        dialog.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        dialog.setCancelable(true)
        val btnNo: Button = dialog.findViewById(R.id.btnNo)
        val btnYes: Button = dialog.findViewById(R.id.btnYes)
        btnNo.setOnClickListener {
            dialog.dismiss()
        }
        btnYes.setOnClickListener {
            val preferences = AppPreferences(this)
            preferences.clearHighScore()
            Toast.makeText(this, R.string.cleared_notify, Toast.LENGTH_SHORT).show()
        }
        dialog.show()
    }

    private fun onBtnNewGame() {
        startActivity(Intent(this, GameActivity::class.java))
    }

    private fun onBtnExit() {
        finish()
    }

}