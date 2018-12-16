package ru.androidacademy.ateam.model.dao;

import android.arch.persistence.room.*;
import android.support.annotation.NonNull;
import io.reactivex.Single;
import ru.androidacademy.ateam.model.tables.Deck;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DeckDao {

    @Query("SELECT * FROM deck")
    Single<List<Deck>> getAllDeck();

    @Query("SELECT COUNT(*) FROM deck")
    int getAllDeckCount();

    @Query("SELECT * FROM deck WHERE deckId = :deckId")
    Single<List<Deck>> getDeckById(@NonNull long deckId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Deck deck);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDeckList(List<Deck> decks);

    @Update
    void update(Deck deck);

    @Delete
    void delete(Deck deck);
}
