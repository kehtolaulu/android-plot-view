package com.kehtolaulu.customviewapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.*

class PlotView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var lineDrawer: ZigZagDrawer
    private val paint = Paint().apply {
        style = Paint.Style.FILL
        color = context
            .obtainStyledAttributes(attrs, R.styleable.PlotView)
            .getColor(R.styleable.PlotView_plotColor, Color.RED)
    }

    fun drawPoints(points: SortedMap<Double, Double>) {
        this.lineDrawer = ZigZagDrawer(points, paint)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        lineDrawer.drawLineOn(canvas)
    }
}
