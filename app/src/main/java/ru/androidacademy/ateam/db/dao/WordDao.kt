package ru.androidacademy.ateam.db.dao


import androidx.room.*
import io.reactivex.Completable
import io.reactivex.Single
import ru.androidacademy.ateam.model.Word


@Dao
interface WordDao {
    @get:Query("SELECT * FROM Word")
    val getAll: Single<List<Word>>

    @Query("SELECT COUNT(*) FROM word WHERE deckId = :deckId")
    fun getCountByDeckId(deckId: Long): Single<Long>

    @Query("SELECT text FROM word WHERE deckId = :deckId")
    fun getTextByDeckId(deckId: Long): Single<List<String>>

    @Query("SELECT * FROM Word WHERE deckId = :deckId")
    fun getByDeckId(deckId: Long): Single<List<Word>>

    @Query("DELETE FROM word WHERE deckId = :deckId")
    fun deleteById(deckId: Long)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(word: Word)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Word>):Completable

    @Update
    fun update(word: Word)

    @Delete
    fun delete(word: Word)

}