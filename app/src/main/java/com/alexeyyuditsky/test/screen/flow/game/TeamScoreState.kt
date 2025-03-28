package com.alexeyyuditsky.test.screen.flow.game

sealed interface TeamScoreState {

    data class Game(
        val score1: Int,
        val score2: Int
    ) : TeamScoreState

    data class Winner(
        val score1: Int,
        val score2: Int
    ) : TeamScoreState
}