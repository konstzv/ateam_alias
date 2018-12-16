package ru.androidacademy.ateam.presentation.presenter

import com.arellomobile.mvp.MvpPresenter
import ru.androidacademy.ateam.di.GameModule
import ru.androidacademy.ateam.model.game.Game
import ru.androidacademy.ateam.presentation.view.SettingsView
import toothpick.Scope
import toothpick.Toothpick
import javax.inject.Inject


class SettingsPresenter:MvpPresenter<SettingsView>(){

    @Inject
    lateinit var currentGame: Game


    val gameScope: Scope = Toothpick.openScopes(
        "GameScope"
    )

    init {
        Toothpick.inject(this,gameScope)
        gameScope.installModules(GameModule())
        Toothpick.inject(this,gameScope)
    }



}