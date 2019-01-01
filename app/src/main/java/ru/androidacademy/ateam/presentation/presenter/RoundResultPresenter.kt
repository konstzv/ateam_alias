package ru.androidacademy.ateam.presentation.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import ru.androidacademy.ateam.App
import ru.androidacademy.ateam.model.Game
import ru.androidacademy.ateam.presentation.view.RoundResultView
import toothpick.Scope
import toothpick.Toothpick
import javax.inject.Inject

@InjectViewState
class RoundResultPresenter : MvpPresenter<RoundResultView>() {

    @Inject
    lateinit var currentGame: Game


    val gameScope: Scope = Toothpick.openScopes(
       App.Scopes.GAME_SCOPE

    )

    init {
        Toothpick.inject(this, gameScope)
    }

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.show(currentGame)
    }
}