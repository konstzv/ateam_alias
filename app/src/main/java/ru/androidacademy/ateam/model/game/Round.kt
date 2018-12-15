package ru.androidacademy.ateam.model.game


data class Round(val team: Team, val playerAnswer: Player, val playerExplain: Player, var wordsGuessed:Int = 0, var skipNum:Int = 3)