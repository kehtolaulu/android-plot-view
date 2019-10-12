package com.kehtolaulu.customviewapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val randomGenerator = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        plot.drawPoints(xToY(x = 1..20, f = this::randomY))
    }

    private fun xToY(x: IntRange, f: (Double) -> Double) =
        x.map(Int::toDouble)
            .associateWith(f)
            .toSortedMap()

    private fun randomY(x: Double) =
        randomGenerator.nextDouble() * (10 + x)
}
