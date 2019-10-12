package com.kehtolaulu.customviewapplication

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.TintTypedArray
import java.util.*


class PlotView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {


    private lateinit var lineDrawer: ZigZagDrawer
    private var points: SortedMap<Double, Double> = sortedMapOf()


    init {
        val a = TintTypedArray.obtainStyledAttributes(
            context,
            attrs,
            R.styleable.PlotView,
            defStyleAttr,
            R.style.PlotViewStyle
        )
        a.recycle()
    }

    fun drawPoints(points: SortedMap<Double, Double>) {
        this.points = points
        this.lineDrawer = ZigZagDrawer(points)
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        lineDrawer.drawLineOn(canvas)
    }

}
