package com.alexeyyuditsky.promocodes.data

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object PromocodesRetrofit {

    private lateinit var promocodesApi: PromocodesApi

    fun create(): PromocodesApi {
        return if (::promocodesApi.isInitialized) {
            promocodesApi
        } else {
            val client = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()

            Retrofit.Builder()
                .baseUrl("https://raw.githubusercontent.com/AlexeyYuditsky/server/master/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create<PromocodesApi>()
                .also { promocodesApi = it }
        }
    }
}