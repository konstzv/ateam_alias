package ru.androidacademy.ateam.ui.activity

import android.os.Bundle
import android.os.PersistableBundle
import com.arellomobile.mvp.MvpAppCompatActivity
import ru.androidacademy.ateam.R
import ru.androidacademy.ateam.presentation.view.SettingsView


class SettingsActivity:MvpAppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.settings_activity)
    }




}