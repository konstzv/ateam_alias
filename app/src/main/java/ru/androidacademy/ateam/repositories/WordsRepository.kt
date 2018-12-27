package ru.androidacademy.ateam.repositories

import io.reactivex.Single
import ru.androidacademy.ateam.App
import ru.androidacademy.ateam.db.AppDatabase
import ru.androidacademy.ateam.model.Word
import toothpick.Toothpick
import javax.inject.Inject


class WordsRepository @Inject constructor() : IWordsRepository {

    @Inject
    lateinit var appDatabase: AppDatabase

    init {
        val appScope = Toothpick.openScope(App.Scopes.APP_SCOPE)
        Toothpick.inject(this, appScope)
    }

    override fun getDeckWordCount(deckId: Long): Single<Long> {
        return appDatabase.wordDao().getCountByDeckId(deckId)
    }

    override fun gettWordsByDeckId(deckId: Long): Single<List<Word>> {
        return appDatabase.wordDao().getByDeckId(deckId)
    }
}