package com.alexeyyuditsky.test.screen.flow.game

interface UiAction {

    fun apply(uiActions: UiActions)

    class ShowWinner(
        private val message: String
    ) : UiAction {
        override fun apply(uiActions: UiActions) {
            uiActions.showWinner(message)
        }
    }

}