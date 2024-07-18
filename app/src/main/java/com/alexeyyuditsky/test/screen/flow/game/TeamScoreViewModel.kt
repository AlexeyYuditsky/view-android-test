package com.alexeyyuditsky.test.screen.flow.game

import androidx.lifecycle.ViewModel
import com.alexeyyuditsky.test.core.log
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TeamScoreViewModel : ViewModel() {

    private val _state = MutableStateFlow<TeamScoreState>(TeamScoreState.Game(0, 0))
    val state = _state.asStateFlow()

    fun increaseTeamOneScore() {
        log(state.hashCode().toString())
        log(_state.hashCode().toString())
        val currentState = state.value
        if (currentState is TeamScoreState.Game) {
            val oldValue = currentState.score1
            val newValue = oldValue + 1
            _state.value = currentState.copy(score1 = newValue)
            if (newValue == WINNER_SCORE) {
                _state.value = TeamScoreState.Winner(
                    winnerTeam = Team.TEAM_1,
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
                _state.value = TeamScoreState.Winner(
                    winnerTeam = Team.TEAM_2,
                    score1 = currentState.score1,
                    score2 = newValue
                )
            }
        }
    }

    private companion object {
        const val WINNER_SCORE = 7
    }
}