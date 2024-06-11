package com.alexeyyuditsky.test.customView.circleDiagram

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CircleDiagramView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private var paint = Paint()
    private val percentages = arrayListOf(31, 30, 10, 9, 20)
    private val colors = arrayListOf(Color.RED, Color.GREEN, Color.CYAN, Color.MAGENTA, Color.BLUE)

    private var lastValue = 0f

    private fun drawArc(canvas: Canvas, color: Int, value: Float) {
        canvas.drawArc(
            /* left = */ minimumWidth.toFloat(),
            /* top = */ minimumHeight.toFloat(),
            /* right = */ width.toFloat(),
            /* bottom = */ height.toFloat(),
            /* startAngle = */ lastValue,
            /* sweepAngle = */ value,
            /* useCenter = */ true,
            /* paint = */ paint.apply { this.color = color }
        )
        lastValue += value
    }

    private fun getValueFromPercentage(percentage: Int): Float {
        return 360f / 100 * percentage
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        percentages.forEachIndexed { index, percantage ->
            val value = getValueFromPercentage(percantage)
            drawArc(canvas, colors[index], value)
        }
    }

}