package ru.androidacademy.ateam.model.dao;

import android.arch.persistence.room.*;
import ru.androidacademy.ateam.model.tables.Words;

import java.util.List;

@Dao
public interface WordsDao {
    @Query("SELECT * FROM words")
    List<Words> getAllWords();

    @Query("SELECT * FROM words WHERE deckId = :deckId")
    List<Words> getAllWordsByDeckId(long deckId);

    @Insert
    void insert(Words words);

    @Update
    void update(Words words);

    @Delete
    void delete(Words words);
}
