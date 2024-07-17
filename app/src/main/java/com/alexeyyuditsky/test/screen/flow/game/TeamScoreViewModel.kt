package com.alexeyyuditsky.test.screen.flow.game

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TeamScoreViewModel : ViewModel() {

    private val _state = MutableLiveData<TeamScoreState>(TeamScoreState.Game(0, 0))
    val state: LiveData<TeamScoreState> = _state

    fun increaseScore(team: Team) {
        val currentState = state.value ?: return
        if (currentState is TeamScoreState.Game) {
            if (team == Team.TEAM_1) {
                val oldValue = currentState.score1
                val newValue = oldValue + 1
                _state.value = currentState.copy(score1 = newValue)
                if (newValue >= WINNER_SCORE) {
                    _state.value = TeamScoreState.Winner(
                        Team.TEAM_1,
                        newValue,
                        currentState.score2
                    )
                }
            } else {
                if (team == Team.TEAM_2) {
                    val oldValue = currentState.score2
                    val newValue = oldValue + 1
                    _state.value = currentState.copy(score2 = newValue)
                    if (newValue >= WINNER_SCORE) {
                        _state.value = TeamScoreState.Winner(
                            Team.TEAM_2,
                            currentState.score1,
                            newValue
                        )
                    }
                }
            }
        }
    }

    private companion object {
        const val WINNER_SCORE = 7
    }
}