package com.alexeyyuditsky.test.customView

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.Timer
import kotlin.concurrent.scheduleAtFixedRate

class BallCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0
) : View(context, attrs, defStyleAttr, defStyleRes) {

    private val density = resources.displayMetrics.density
    private val paint = Paint().apply { color = Color.RED }

    init {
        Timer().scheduleAtFixedRate(
            period = 10,
            delay = 100
        ) {
            invalidate()
        }
    }

    private var theX = 30f
    private var theY = 80f

    private var xDirection = 1
    private var yDirection = 1

    private val delta = 5f

    private val ballRadius = 10f * density
    private val ballSize = delta * 5

    private val xOffset = 6
    private val yOffset = 12

    private val speed = 30

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        if (width - theX < ballSize || theX < ballSize)
            xDirection *= -1

        if (height - theY < ballSize || theY < ballSize)
            yDirection *= -1

        theX += delta * xOffset / speed * xDirection
        theY += delta * yOffset / speed * yDirection

        canvas.drawCircle(theX, theY, ballRadius, paint)
    }
}