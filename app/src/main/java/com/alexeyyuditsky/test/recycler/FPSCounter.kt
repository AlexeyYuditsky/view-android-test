package com.alexeyyuditsky.test.recycler

import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.Choreographer

class FPSCounter(private val listener: Listener) : Choreographer.FrameCallback {

    interface Listener {
        fun onFPSUpdate(fps: Double)
    }

    private var frameCount = 0
    private var startTime = 0L

    private val choreographer = Choreographer.getInstance()
    private val handler = Handler(Looper.getMainLooper())

    override fun doFrame(frameTimeNanos: Long) {
        frameCount++
        val currentTime = SystemClock.elapsedRealtime()

        if (startTime == 0L) {
            startTime = currentTime
        } else {
            val elapsedTime = currentTime - startTime
            val fps = frameCount.toDouble() * 1000 / elapsedTime
            listener.onFPSUpdate(fps)

            // Reset for the next interval
            frameCount = 0
            startTime = currentTime
        }

        choreographer.postFrameCallback(this)
    }

    fun start() {
        choreographer.postFrameCallback(this)
    }

    fun stop() {
        choreographer.removeFrameCallback(this)
        handler.removeCallbacksAndMessages(null)
    }
}