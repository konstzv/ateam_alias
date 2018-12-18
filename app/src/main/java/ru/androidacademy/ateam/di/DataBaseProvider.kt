package ru.androidacademy.ateam.di

import android.content.Context
import androidx.room.Room
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