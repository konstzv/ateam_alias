package ru.androidacademy.ateam.repositories

import io.reactivex.Single
import ru.androidacademy.ateam.model.Word

interface IWordsRepository {

    fun gettWordsByDeckId(deckId: Long): Single<List<Word>>
    fun getDeckWordCount(deckId: Long): Single<Long>
}
