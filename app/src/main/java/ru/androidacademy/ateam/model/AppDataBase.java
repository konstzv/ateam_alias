package ru.androidacademy.ateam.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import ru.androidacademy.ateam.model.dao.WordsDao;
import ru.androidacademy.ateam.model.tables.Words;

@Database(entities = {Words.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract WordsDao wordsDao();
}

