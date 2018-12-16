package ru.androidacademy.ateam.di

import ru.androidacademy.ateam.model.game.Game
import toothpick.config.Module


class GameModule: Module() {
    init {

        bind(Game::class.java)
            .to(Game::class.java).instancesInScope()

    }
}