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

class BlockAdjustment(private val positions: MutableList<Int>,
                      private val blockNumbers: MutableList<Int>,
                      private val partialIncrementsWithZero: MutableList<Int>,
                      insertedIndexes: MutableList<Int>) {
    private val insertedPositions = insertedIndexes.map { positions[it] }
    private val partialIncrements = insertedIndexes.map { partialIncrementsWithZero[it] }
    private val insertedPositionsStart = insertedPositions.zip(partialIncrements)
        .filter { (_, list2) -> list2 == 1 }
        .map { (list1, _) -> list1 }
    val newPositions = mutableListOf<Int>()
    private val outputForGap = mutableListOf<Int>()
    private var posIndex = 0
    private var inBlock = false
    private var shiftCount = 0
    var pairForShift = emptyList<Pair<Int, Int>>()

    fun generateOutputForGap() {
        insertedPositionsStart.toSet().toList().forEach {
            var partialMaxGap = 1
            /*
                verticalStartIndexes: list of indexes within insertedPositions that
                                       match one of unique insertedPositionsStart
            */
            val verticalStartIndexes = insertedPositions.withIndex()
                .filter { (_, value) -> value == it }
                .map { (index, _) -> index }
            if (partialIncrements.size > 1) {
                verticalStartIndexes.forEach {
                    var idx = it
                    try {
                        while (partialIncrements[idx] < partialIncrements[idx + 1]) {
                            partialMaxGap = max(partialIncrements[idx + 1], partialMaxGap)
                            idx += 1
                            if ( (partialIncrements.size - 1) == idx ) { break }
                            if ( partialIncrements[idx] >= partialIncrements[idx + 1] ) { break }
                        }
                    } catch (_: IndexOutOfBoundsException) {  }
                }
            }
            outputForGap.add(partialMaxGap)
        }
        pairForShift = (insertedPositionsStart.toSet().toList()).zip(outputForGap)

        var pos: Int
        positions.forEach {
            pos = it
            inBlock = partialIncrementsWithZero[posIndex] > 0
            shiftCount =
                if (inBlock) {
                    pairForShift
                    .filter { (list1, _) -> list1 <= pos - partialIncrementsWithZero[posIndex] }
                    .sumOf { (_, list2) -> list2 }
                } else {
                    pairForShift
                    .filter { (list1, _) -> list1 <= pos - blockNumbers[posIndex] }
                    .sumOf { (_, list2) -> list2 } - blockNumbers[posIndex]
                }
            pos += shiftCount
            newPositions.add(pos)
            posIndex += 1
        }
    }
}