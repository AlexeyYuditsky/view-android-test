package com.alexeyyuditsky.promocodes.data

import com.alexeyyuditsky.promocodes.domain.PromocodesRepository

class PromocodesRepositoryImpl(
    private val api: PromocodesApi = PromocodesRetrofit.create()
) : PromocodesRepository {
    override suspend fun fetchPromocodes(): Result =
        try {
            val promocodes = api.fetchPromocodes().promocodes
            Result.Success(promocodes)
        } catch (e: Exception) {
            Result.Error(e)
        }
}