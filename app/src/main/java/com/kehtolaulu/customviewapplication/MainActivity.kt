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

        val sortedMap =
            (1..20).asSequence()
                .map { x -> x.toDouble() }
                .associateWith { x -> randomY(x) }
                .toSortedMap()
        plot.drawPoints(sortedMap)
    }

    private fun randomY(x: Double) = randomGenerator.nextDouble() * (10 + x)
}
