package com.alexeyyuditsky.test.screen.customView.drawCircle

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.properties.Delegates

@SuppressLint("ClickableViewAccessibility")
class DrawCircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val paint = Paint().apply {
        color = Color.MAGENTA
        style = Paint.Style.STROKE
        strokeWidth = 10f
    }

    private var firstPointX by Delegates.notNull<Float>()
    private var firstPointY by Delegates.notNull<Float>()
    private var secondPointX by Delegates.notNull<Float>()
    private var secondPointY by Delegates.notNull<Float>()

    private var radius by Delegates.notNull<Float>()

    private val circeList = mutableListOf<CircleData>()

    private var isFirstLaunchOnDraw = true

    init {
        setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    firstPointX = event.x
                    firstPointY = event.y
                    true
                }

                MotionEvent.ACTION_MOVE -> {
                    secondPointX = event.x
                    secondPointY = event.y
                    invalidate()
                    true
                }

                MotionEvent.ACTION_UP -> {
                    circeList.add(CircleData(firstPointX, firstPointY, radius))
                    true
                }

                else -> false
            }
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (isFirstLaunchOnDraw) {
            isFirstLaunchOnDraw = false
        } else {
            radius = sqrt(
                (secondPointX - firstPointX).pow(2) +
                        (secondPointY - firstPointY).pow(2)
            )

            canvas.drawCircle(firstPointX, firstPointY, radius, paint)

            circeList.forEach { circleData ->
                canvas.drawCircle(
                    circleData.x,
                    circleData.y,
                    circleData.radius,
                    paint
                )
            }
        }
    }
}

private data class CircleData(
    val x: Float,
    val y: Float,
    val radius: Float
)