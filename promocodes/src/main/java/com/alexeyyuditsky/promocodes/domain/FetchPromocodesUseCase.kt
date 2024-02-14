package com.alexeyyuditsky.promocodes.domain

import com.alexeyyuditsky.promocodes.data.PromocodesRepositoryImpl
import com.alexeyyuditsky.promocodes.data.Result
import com.alexeyyuditsky.promocodes.ui.State
import java.io.IOException
import java.net.UnknownHostException

class FetchPromocodesUseCase(
    private val repository: PromocodesRepository = PromocodesRepositoryImpl()
) {
    suspend operator fun invoke(): State =
        when (val result = repository.fetchPromocodes()) {
            is Result.Success -> {
                if (result.data.isNullOrEmpty()) {
                    State.Error("No promocodes")
                } else {
                    State.Next(result.data.first())
                }
            }

            is Result.Error -> {
                State.Error(
                    if (result.throwable is UnknownHostException)
                        "No internet"
                    else
                        "Something went wrong"
                )
            }
        }
}