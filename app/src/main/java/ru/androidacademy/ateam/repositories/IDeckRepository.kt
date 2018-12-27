package ru.androidacademy.ateam.repositories

import io.reactivex.Single
import ru.androidacademy.ateam.model.Deck

interface IDeckRepository {

    fun getAllDecks(): Single<List<Deck>>
}
