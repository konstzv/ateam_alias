package ru.androidacademy.ateam.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import ru.androidacademy.ateam.model.dao.DeckDao;
import ru.androidacademy.ateam.model.dao.WordDao;
import ru.androidacademy.ateam.model.tables.Deck;
import ru.androidacademy.ateam.model.tables.Word;

@Database(entities = {Word.class, Deck.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract WordDao wordDao();
    public abstract DeckDao deckDao();
}

