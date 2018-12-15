package ru.androidacademy.ateam.model.dao;

import android.arch.persistence.room.*;
import android.support.annotation.NonNull;
import io.reactivex.Flowable;
import io.reactivex.Single;
import ru.androidacademy.ateam.model.tables.Word;

import java.util.List;

@Dao
public interface WordDao {
    @Query("SELECT * FROM Word")
    Single<List<Word>> getAllWords();

    @Query("SELECT word FROM word WHERE deckId = :deckId")
    Single<List<String>> getWordByDeckId(@NonNull long deckId);

    @Query("SELECT * FROM Word WHERE deckId = :deckId")
    Single<List<Word>> getAllWordByDeckId(@NonNull long deckId);

    @Query("DELETE FROM word WHERE deckId = :deckId")
    Single deleteById(@NonNull long deckId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single insert(Word word);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single insertWordList(List<Word> list);

    @Update
    Flowable update(Word word);

    @Delete
    Single delete(Word word);
}
