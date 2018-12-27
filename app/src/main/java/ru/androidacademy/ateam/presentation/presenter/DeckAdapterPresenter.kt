package ru.androidacademy.ateam.presentation.presenter

import com.arellomobile.mvp.MvpPresenter
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.androidacademy.ateam.App
import ru.androidacademy.ateam.presentation.view.DeckAdapterView
import ru.androidacademy.ateam.repositories.IWordsRepository
import toothpick.Scope
import toothpick.Toothpick
import javax.inject.Inject


class DeckAdapterPresenter : MvpPresenter<DeckAdapterView>() {

    @Inject
    lateinit var wordsRepository: IWordsRepository

    init {
        val gameScope: Scope = Toothpick.openScopes(
            App.Scopes.GAME_SCOPE
        )
        Toothpick.inject(this, gameScope)
    }

    fun getDeckWordCount(deckId: Long): Single<Long> {
        return wordsRepository
            .getDeckWordCount(deckId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}