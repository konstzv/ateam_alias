package ru.androidacademy.ateam

import android.app.Application
import com.facebook.stetho.Stetho
import ru.androidacademy.ateam.db.AppDatabase
import ru.androidacademy.ateam.di.AppModule
import toothpick.Toothpick
import javax.inject.Inject


class App : Application() {


    enum class Scopes {
        APP_SCOPE, GAME_SCOPE
    }


    @Inject
    lateinit var database: AppDatabase

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this);
        initScope()
        prepopulateDatabase()
    }

    private fun prepopulateDatabase() {
        database.openHelper.writableDatabase
    }

    private fun initScope() {
        val appScope = Toothpick.openScope(Scopes.APP_SCOPE)
        appScope.installModules(AppModule(applicationContext))
        Toothpick.inject(this, appScope)
    }


}