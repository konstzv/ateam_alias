package ru.androidacademy.ateam.di

import ru.androidacademy.ateam.model.Game
import toothpick.config.Module


class GameModule : Module() {
    init {
        bind(Game::class.java)
            .to(Game::class.java).singletonInScope()
    }
}