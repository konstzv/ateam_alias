package ru.androidacademy.ateam.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Word(
    var text: String
    , var deckId: Long
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
