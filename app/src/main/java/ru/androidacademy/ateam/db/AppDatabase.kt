package ru.androidacademy.ateam.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ru.androidacademy.ateam.db.dao.DeckDao
import ru.androidacademy.ateam.db.dao.WordDao
import ru.androidacademy.ateam.model.Deck
import ru.androidacademy.ateam.model.Word


@Database(entities = [Word::class, Deck::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
    abstract fun deckDao(): DeckDao

}