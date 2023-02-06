/*
 * MIT License
 *
 * Copyright (c) 2023 Jungsoo Lee
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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