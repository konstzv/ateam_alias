package ru.androidacademy.ateam.presentation.view

import com.arellomobile.mvp.MvpView
import ru.androidacademy.ateam.model.game.Game

interface RoundResultView:MvpView {
    fun show(game:Game)
}
