package ru.androidacademy.ateam;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import ru.androidacademy.ateam.model.AppDataBase;

public class App extends Application {
    public static Context appContext;

    private static AppDataBase appDataBase;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = this;

        appDataBase = Room.databaseBuilder(this,AppDataBase.class, "database")
                .build();
    }

    public static Context getAppContext() {
        return appContext;
    }

    public static AppDataBase getDbInstance(){
        return appDataBase;
    }
}
