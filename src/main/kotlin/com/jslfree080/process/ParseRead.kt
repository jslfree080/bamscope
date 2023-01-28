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

class ParseRead(samtoolsViewLines: List<String>) {
    // Parse the output to extract the read positions and bases
    private val nonEmptyLines = samtoolsViewLines.filter { it.isNotEmpty() }
    val positions = mutableListOf<Int>()
    val insertedIndexes = mutableListOf<Int>()
    val bases = mutableListOf<String>()
    val qualities = mutableListOf<Int>()
    val directions = mutableListOf<String>()
    val pseudoReferenceForLegend = mutableListOf<String>()
    val blockNumbers = mutableListOf<Int>()
    val partialIncrementWithZero = mutableListOf<Int>()
    val yCoordinates = mutableListOf<Int>()
    private var yCoordinate = 50

    fun appender() {
        val sb = StringBuilder()
        val ths = mutableListOf<Thread>()
        nonEmptyLines.forEach {
            yCoordinate += 100
            var blockNumber = 0
            val fields = it.split("\t")
            val flag = fields[1].toInt()
            val cigarString: String = fields[5]
            val seq: String = fields[9]
            val qual: String = fields[10]
            var refPos = fields[3].toInt()
            var seqPos = 0
            val match = Regex("""(\d+)([MIDNSHP=X])""").findAll(cigarString)

            match.forEach {
                val th = Thread {
                    val count = it.groupValues[1].toInt()
                    println(count)
                    val operation = it.groupValues[2]
                    println(operation)
                }
                th.start()
                ths.add(th)
            }

            ths.forEach { thread -> thread.join() }
        }
    }
}