package com.kehtolaulu.customviewapplication

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import java.util.*

private typealias Point = Pair<Double, Double>

class ZigZagDrawer(private val points: SortedMap<Double, Double>) {
    private lateinit var canvas: Canvas

    private val minX = points.firstKey()
    private val maxX = points.lastKey()
    private val minY = points.values.min() ?: 100.0
    private val maxY = points.values.max() ?: 200.0

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        style = Paint.Style.FILL
        color = Color.RED
    }

    fun drawLineOn(canvas: Canvas) {
        this.canvas = canvas
        for ((a, b) in points.asIterable().zipWithNext()) {
            drawLine(a.toPair(), b.toPair())
        }
    }

    private fun drawLine(a: Point, b: Point) {
        val (x1, y1) = scale(a)
        val (x2, y2) = scale(b)
        canvas.drawLine(
            x1.toFloat(), y1.toFloat(),
            x2.toFloat(), y2.toFloat(),
            paint
        )
    }

    private fun scale(p: Point): Point {
        val (x, y) = p
        return (10 + (x - minX) * canvas.width / (maxX - minX)) to
                (10 + (y - minY) * canvas.height / (maxY - minY))
    }
}

