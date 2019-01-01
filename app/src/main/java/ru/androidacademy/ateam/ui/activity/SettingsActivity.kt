package ru.androidacademy.ateam.ui.activity

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import ru.androidacademy.ateam.App
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.di.GameModule
import ru.androidacademy.ateam.ui.fragment.BasicSettingsFragment
import ru.androidacademy.ateam.ui.fragment.DeckChooserSettingsFragment
import ru.androidacademy.ateam.ui.fragment.TeamsFragment
import toothpick.Scope
import toothpick.Toothpick
import java.util.*


class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameScope: Scope = Toothpick.openScopes(
            App.Scopes.APP_SCOPE,
            App.Scopes.GAME_SCOPE
        )
        Objects.requireNonNull<ActionBar>(supportActionBar).setTitle(R.string.bar_settings)

        gameScope.installModules(GameModule())
        Toothpick.inject(this, gameScope)

        setContentView(R.layout.settings_activity)


        showDescSett()
    }

    fun showSettings() {
        supportFragmentManager.beginTransaction().replace(R.id.contrainer, BasicSettingsFragment())
//            .addToBackStack(null).commit()
            .commit()
    }

    fun showTeams() {
        supportFragmentManager.beginTransaction().replace(R.id.contrainer, TeamsFragment())
//            .addToBackStack(null).commit()
            .commit()
    }

    fun showDescSett() {
        supportFragmentManager.beginTransaction().replace(R.id.contrainer, DeckChooserSettingsFragment())
//            .addToBackStack(null).commit()
            .commit()
    }

    fun onCardChoosed() {
        showTeams()
    }

    fun onTeamFinish() {
        showSettings()
    }


}