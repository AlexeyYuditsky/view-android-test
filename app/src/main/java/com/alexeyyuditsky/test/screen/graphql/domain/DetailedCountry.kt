package com.alexeyyuditsky.test.screen.graphql.domain

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DetailedCountry(
    val code: String,
    val name: String,
    val capital: String,
    val emoji: String,
    val currency: String,
    val languages: List<String>,
    val continent: String
) : Parcelable