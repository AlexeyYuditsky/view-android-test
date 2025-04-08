package com.alexeyyuditsky.dagger.atm.core

class Result(
    val status: Status,
    val nestedCommandRouter: CommandRouter? = null
) {

    companion object {
        fun invalid(): Result =
            Result(Status.INVALID, null)

        fun handled(): Result =
            Result(Status.HANDLED, null)

        fun enterNestedCommandSet(nestedCommandRouter: CommandRouter): Result =
            Result(Status.HANDLED, nestedCommandRouter)
    }

}