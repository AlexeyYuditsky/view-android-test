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

    private val bottomPaint = Paint().apply {
        color = Color.GREEN
        strokeWidth = 12f
    }

    private val topPaint = Paint().apply {
        color = Color.RED
        strokeWidth = 12f
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val leftX = 0.1f * width
        val leftY = 0.8f * height

        val rightX = 0.9f * width
        val rightY = 0.8f * height

        val bottomX = 0.45f * width
        val bottomY = 0.9f * height

        val topX = 0.5f * width
        val topY = 0.1f * height

        canvas.drawLine(leftX, leftY, rightX, rightY, bottomPaint)
        canvas.drawLine(leftX, leftY, bottomX, bottomY, bottomPaint)
        canvas.drawLine(rightX, rightY, bottomX, bottomY, bottomPaint)
        canvas.drawLine(leftX, leftY, topX, topY, topPaint)
        canvas.drawLine(rightX, rightY, topX, topY, topPaint)
        canvas.drawLine(bottomX, bottomY, topX, topY, topPaint)
    }
}