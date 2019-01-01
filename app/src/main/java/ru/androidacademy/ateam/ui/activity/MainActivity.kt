package ru.androidacademy.ateam.ui.activity

import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import ru.androidacademy.ateam.R


class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()

    }

    private fun setListeners() {
        activity_main_button_new_game.setOnClickListener {
            startNewGame()
        }
    }

    private fun startNewGame() {
        val intent = Intent(this, SettingsActivity::class.java)
        startActivity(intent)
    }
}