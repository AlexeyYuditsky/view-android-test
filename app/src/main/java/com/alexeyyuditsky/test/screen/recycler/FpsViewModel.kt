package com.alexeyyuditsky.test.screen.recycler

import android.view.Choreographer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.alexeyyuditsky.test.core.log

class FpsViewModel : ViewModel(), Choreographer.FrameCallback {

    private val _fpsLiveData = MutableLiveData<String>()
    val fpsLiveData: LiveData<String> get() = _fpsLiveData

    private val choreographer = Choreographer.getInstance()

    private var framesRendered = 0
    private var lastFrameTimeNanos = 0L

    init {
        choreographer.postFrameCallback(this)
    }

    override fun doFrame(frameTimeNanos: Long) {
        log(frameTimeNanos, "fps")
        calculateAndDisplayFps(frameTimeNanos)
        choreographer.postFrameCallback(this)
    }

    private fun calculateAndDisplayFps(currentTimeNanos: Long) {
        if (lastFrameTimeNanos > 0) {
            val elapsedNanos = currentTimeNanos - lastFrameTimeNanos
            val elapsedMillis = elapsedNanos / 1_000_000
            val fps = (framesRendered * 1_000) / elapsedMillis

            _fpsLiveData.value = fps.toString()

            framesRendered = 0
        }

        lastFrameTimeNanos = currentTimeNanos
        framesRendered++
    }
}