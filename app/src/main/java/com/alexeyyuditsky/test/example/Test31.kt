package com.alexeyyuditsky.test.example

import com.squareup.moshi.Json
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

const val url =
    "https://raw.githubusercontent.com/AlexeyYuditsky/server/master/promocodes.json?token=GHSAT0AAAAAACODASTVOUS7Y5D2C3RPHGHKZUXT2JQ"

data class PromoCodesResponse(
    @Json(name = "promocodes") val promoCodes: List<String>
)

fun main() {
    val jsonResponse = getJsonFromServer(url)

    val promoCodesResponse = parseJsonWithMoshi(jsonResponse)
    println(promoCodesResponse)

    promoCodesResponse?.let {
        println("Received promo codes: ${it.promoCodes}")
    } ?: run {
        println("Failed to fetch or parse promo codes")
    }
}

fun parseJsonWithMoshi(json: String?): PromoCodesResponse? {
    if (json == null) return null

    val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    val jsonAdapter = moshi.adapter(PromoCodesResponse::class.java)

    return jsonAdapter.fromJson(json)
}

fun getJsonFromServer(urlString: String): String? {
    val url = URL(urlString)
    val urlConnection = url.openConnection() as HttpURLConnection
    return try {
        val responseCode = urlConnection.responseCode
        if (responseCode == HttpURLConnection.HTTP_OK) { // Проверка на успешный ответ
            val inputStream = urlConnection.inputStream
            val bufferedReader = BufferedReader(InputStreamReader(inputStream))
            val response = StringBuilder()
            var line: String?
            while (bufferedReader.readLine().also { line = it } != null) {
                response.append(line)
            }
            bufferedReader.close()
            response.toString()
        } else {
            // Обработка ошибок сервера
            println("Server returned HTTP response code: $responseCode")
            null
        }
    } catch (e: Exception) {
        // Обработка исключений
        e.printStackTrace()
        null
    } finally {
        urlConnection.disconnect()
    }
}
