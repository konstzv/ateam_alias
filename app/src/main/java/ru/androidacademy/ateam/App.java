package ru.androidacademy.ateam;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import ru.androidacademy.ateam.model.AppDataBase;

public class App extends Application {
    private static Context appContext;
    private static App instance;

    private static AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        appDataBase = Room.databaseBuilder(this, AppDataBase.class, "database")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public static AppDataBase getDbInstance() {
        return appDataBase;
    }
}
