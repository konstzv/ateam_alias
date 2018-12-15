package ru.androidacademy.ateam.model.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
   public long id;
   public String word;
   public long deckId;
}


