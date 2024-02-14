package com.alexeyyuditsky.promocodes.domain

import com.alexeyyuditsky.promocodes.data.Result

interface PromocodesRepository {

    suspend fun fetchPromocodes(): Result
}
