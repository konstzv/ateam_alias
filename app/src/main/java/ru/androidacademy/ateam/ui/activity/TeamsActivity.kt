package ru.androidacademy.ateam.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.ui.fragment.TeamsFragment

class TeamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_teams, TeamsFragment())
            .commit()
    }
}
