package ru.androidacademy.ateam.di

import android.content.Context
import ru.androidacademy.ateam.db.AppDatabase
import ru.androidacademy.ateam.repositories.DeckRepository
import ru.androidacademy.ateam.repositories.IDeckRepository
import ru.androidacademy.ateam.repositories.IWordsRepository
import ru.androidacademy.ateam.repositories.WordsRepository
import toothpick.config.Module


class AppModule(applicationContext: Context) : Module() {
    init {
        bind(Context::class.java).toInstance(applicationContext)
        bind(AppDatabase::class.java).toProvider(DataBaseProvider::class.java)
        bind(IDeckRepository::class.java)
            .to(DeckRepository::class.java).instancesInScope()
        bind(IWordsRepository::class.java)
            .to(WordsRepository::class.java).instancesInScope()
    }
}