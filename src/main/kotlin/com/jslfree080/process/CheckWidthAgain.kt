package com.jslfree080.process

import kotlin.math.*

class CheckWidthAgain(private val width: Int, private val yCoordinates: MutableList<Int>) {
    private val lowerLimit = ceil(40 * exp(-0.0015 * (yCoordinates.max() + 2))).toInt()
    private val higherLimit = floor(51 * exp(0.0055 * (yCoordinates.max() + 2))).toInt()

    fun expDecayResult(): Boolean {
        return if (width !in lowerLimit..higherLimit) {
            System.err.println(
                "Try setting width (current: $width) between $lowerLimit to $higherLimit for this read depth!"
            )
            false
        } else {
            true
        }
    }
}