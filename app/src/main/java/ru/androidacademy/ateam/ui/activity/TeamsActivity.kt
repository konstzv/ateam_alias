package ru.androidacademy.ateam.ui.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.ActionBar
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.ui.fragment.TeamsFragment
import java.util.*

class TeamsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_teams)
        Objects.requireNonNull<ActionBar>(supportActionBar).setTitle(R.string.bar_team)

        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_teams, TeamsFragment())
            .commit()
    }
}
