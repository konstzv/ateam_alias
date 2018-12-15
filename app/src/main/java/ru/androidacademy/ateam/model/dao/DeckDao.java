package ru.androidacademy.ateam.model.dao;

import android.arch.persistence.room.*;
import android.support.annotation.NonNull;
import io.reactivex.Single;
import ru.androidacademy.ateam.model.tables.Deck;

import java.util.List;

@Dao
public interface DeckDao {

    @Query("SELECT * FROM deck")
    Single<List<Deck>> getAllDeck();

    @Query("SELECT * FROM deck WHERE deckId = :deckId")
    Single<List<Deck>> getDeckById(@NonNull long deckId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single insert(Deck deck);

    @Update
    Single update(Deck deck);

    @Delete
    Single delete(Deck deck);
}
