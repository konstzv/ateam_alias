package ru.androidacademy.ateam.model.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Words {
    @PrimaryKey
    long id;
    String word;
    int deckId;
}


