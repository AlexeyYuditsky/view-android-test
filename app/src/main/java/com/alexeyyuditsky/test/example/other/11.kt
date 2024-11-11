package com.alexeyyuditsky.test.example.other

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow

fun main() {
    val stateLikeStateFlow = MutableSharedFlow<Int>(
        replay = 1, // Храним последнее значение
        extraBufferCapacity = 0, // Не позволяем буферу накапливать дополнительные значения
        onBufferOverflow = BufferOverflow.DROP_OLDEST // При переполнении удаляем старые значения
    )
}