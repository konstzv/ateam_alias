package ru.androidacademy.ateam.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters

import ru.androidacademy.ateam.model.dao.DeckDao
import ru.androidacademy.ateam.model.dao.WordDao


@Database(entities = [WordDao::class,DeckDao::class], version = 7, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wordDao(): WordDao
    abstract fun deckDao(): DeckDao

}