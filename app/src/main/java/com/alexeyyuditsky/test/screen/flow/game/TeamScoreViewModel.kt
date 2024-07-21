package com.alexeyyuditsky.test.screen.flow.game

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class TeamScoreViewModel : ViewModel() {

    private val _state = MutableStateFlow<TeamScoreState>(TeamScoreState.Game(0, 0))
    val state = _state.asStateFlow()

    private val _action = MutableSharedFlow<UiAction>(extraBufferCapacity = 1)
    val action = _action.asSharedFlow()

    fun increaseTeamOneScore() {
        val currentState = state.value
        if (currentState is TeamScoreState.Game) {
            val oldValue = currentState.score1
            val newValue = oldValue + 1
            _state.value = currentState.copy(score1 = newValue)
            if (newValue == WINNER_SCORE) {
                val action = UiAction.ShowWinner("Winner ${Team.TEAM_1}")
                _action.tryEmit(action)
                _state.value = TeamScoreState.Winner(
                    score1 = newValue,
                    score2 = currentState.score2
                )
            }
        }
    }

    fun increaseTeamTwoScore() {
        val currentState = _state.value
        if (currentState is TeamScoreState.Game) {
            val oldValue = currentState.score2
            val newValue = oldValue + 1
            _state.value = currentState.copy(score2 = newValue)
            if (newValue == WINNER_SCORE) {
                val action = UiAction.ShowWinner("Winner ${Team.TEAM_2}")
                _action.tryEmit(action)
                _state.value = TeamScoreState.Winner(
                    score1 = currentState.score1,
                    score2 = newValue
                )
            }
        }
    }

    private companion object {
        const val WINNER_SCORE = 1
    }
}