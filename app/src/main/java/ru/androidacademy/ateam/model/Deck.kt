package ru.androidacademy.ateam.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Deck(
    var name: String
    , var difficulty: Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}