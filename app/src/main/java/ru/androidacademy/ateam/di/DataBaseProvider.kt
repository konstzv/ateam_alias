package ru.androidacademy.ateam.di

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import ru.androidacademy.ateam.db.AppDatabase
import toothpick.ProvidesSingletonInScope
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton


@Singleton
@ProvidesSingletonInScope
class DataBaseProvider : Provider<AppDatabase> {
    @Inject
    lateinit var context: Context

    override fun get(): AppDatabase = Room
        .databaseBuilder(context.applicationContext, AppDatabase::class.java, "alias")
        .fallbackToDestructiveMigration()
        .build()


}