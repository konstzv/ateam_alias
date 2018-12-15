package ru.androidacademy.ateam.model.tables;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import ru.androidacademy.ateam.model.Dificult;

@Entity
public class Deck {
    @PrimaryKey(autoGenerate = true)
   public long deckId;
   public String deckName;
   public int dificult;
   public int countWordInDeck;

}
