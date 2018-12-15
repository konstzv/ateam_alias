package ru.androidacademy.ateam.model.tables;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Deck {
    @PrimaryKey
    long deckId;
    String deckName;
    int dificult;
}
