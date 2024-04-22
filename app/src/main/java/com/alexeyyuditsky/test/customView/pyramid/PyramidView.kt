package com.alexeyyuditsky.test.customView.pyramid

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class PyramidView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val basePaint = Paint().apply {
        color = Color.GREEN
        strokeWidth = 12f
    }

    private val peekPaint = Paint().apply {
        color = Color.RED
        strokeWidth = 12f
    }

    init {
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val firstX = 0.1f * width
        val firstY = 0.85f * height

        val secondX = 0.9f * width
        val secondY = 0.85f * height

        val thirdX = 0.4f * width
        val thirdY = 0.95f * height

        val peekX = 0.5f * width
        val peekY = 0.1f * height

        canvas.drawLine(firstX, firstY, secondX, secondY, basePaint)
        canvas.drawLine(firstX, firstY, thirdX, thirdY, basePaint)
        canvas.drawLine(secondX, secondY, thirdX, thirdY, basePaint)
        canvas.drawLine(peekX, peekY, firstX, firstY, peekPaint)
        canvas.drawLine(peekX, peekY, secondX, secondY, peekPaint)
        canvas.drawLine(peekX, peekY, thirdX, thirdY, peekPaint)
    }
}