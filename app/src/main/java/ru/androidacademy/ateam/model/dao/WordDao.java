package ru.androidacademy.ateam.model.dao;

import android.arch.persistence.room.*;
import android.support.annotation.NonNull;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import ru.androidacademy.ateam.model.tables.Word;

import java.util.List;

@Dao
public interface WordDao {
    @Query("SELECT * FROM Word")
    Single<List<Word>> getAllWords();
    @Query("SELECT COUNT(*) FROM Word")
    int getCountWords();

    @Query("SELECT word FROM word WHERE deckId = :deckId")
    Single<List<String>> getWordByDeckId(@NonNull long deckId);

    @Query("SELECT * FROM Word WHERE deckId = :deckId")
    Single<List<Word>> getAllWordByDeckId(@NonNull long deckId);



    @Query("DELETE FROM word WHERE deckId = :deckId")
    void deleteById(@NonNull long deckId);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertWordList(List<Word> list);

    @Update
    void update(Word word);

    @Delete
    void delete(Word word);
}
