package ru.androidacademy.ateam.repositories

import io.reactivex.Single
import ru.androidacademy.ateam.App
import ru.androidacademy.ateam.db.AppDatabase
import ru.androidacademy.ateam.model.Deck
import toothpick.Toothpick
import javax.inject.Inject


class DeckRepository @Inject constructor() : IDeckRepository {

    @Inject
    lateinit var appDatabase: AppDatabase

    init {
        val appScope = Toothpick.openScopes(App.Scopes.APP_SCOPE)
        Toothpick.inject(this, appScope)
    }

    override fun getAllDecks(): Single<List<Deck>> {
        return appDatabase.deckDao().getAll
    }
}