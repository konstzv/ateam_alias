package ru.androidacademy.ateam.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
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
