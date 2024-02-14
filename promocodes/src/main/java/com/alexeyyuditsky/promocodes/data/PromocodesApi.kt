package com.alexeyyuditsky.promocodes.data

import retrofit2.http.GET

interface PromocodesApi {

    @GET("promocodes.json?token=GHSAT0AAAAAACJRUSKDWT2DAORIRU47OK42ZMTKBDA")
    suspend fun fetchPromocodes(): Response
}
