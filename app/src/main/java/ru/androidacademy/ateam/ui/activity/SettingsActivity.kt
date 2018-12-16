package ru.androidacademy.ateam.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import com.arellomobile.mvp.MvpAppCompatActivity
import org.jetbrains.anko.startActivity
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.di.GameModule
import ru.androidacademy.ateam.presentation.view.SettingsView
import ru.androidacademy.ateam.ui.fragment.BasicSettingsFragment
import ru.androidacademy.ateam.ui.fragment.PreGameDeckChooseFragment
import ru.androidacademy.ateam.ui.fragment.TeamsFragment
import toothpick.Scope
import toothpick.Toothpick


class SettingsActivity: AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameScope: Scope = Toothpick.openScopes(
            "GameScope"
        )
        gameScope.installModules(GameModule())
        Toothpick.inject(this,gameScope)
        setContentView(R.layout.settings_activity)


        showDescSett()
    }

    fun showSettings(){
        supportFragmentManager.beginTransaction().replace(R.id.contrainer,BasicSettingsFragment())
//            .addToBackStack(null).commit()
            .commit()
    }

    fun showTeams(){
        supportFragmentManager.beginTransaction().replace(R.id.contrainer,TeamsFragment())
//            .addToBackStack(null).commit()
            .commit()
    }

    fun showDescSett(){
        supportFragmentManager.beginTransaction().replace(R.id.contrainer,PreGameDeckChooseFragment())
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