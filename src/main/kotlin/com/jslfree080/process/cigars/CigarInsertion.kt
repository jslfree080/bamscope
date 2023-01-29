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
package com.jslfree080.process.cigars

import java.lang.StringBuilder

class CigarInsertion(private val sb: StringBuilder,
                     var parameterMID: ParameterMID,
                     var seqPos: Int,
                     var refPos: Int,
                     var qual: String,
                     var insertedIndexes: MutableList<Int>) {
    var count = 0
    var partialIncrement = 0

    fun commonAppend() {
        for (c in 0 until count) {
            parameterMID.yCoordinates.add(parameterMID.yCoordinate)

            parameterMID.positions.add(refPos + c)

            sb.append(if ((parameterMID.flag and 0x10) == 0x10) "-" else "+")
            parameterMID.directions.add(sb.toString())
            sb.setLength(0)
        }
    }

    fun pseudoReferenceForLegendAppend() {
        for (c in 0 until count) {
            sb.append("gap")
            parameterMID.pseudoReferenceForLegend.add(sb.toString())
            sb.setLength(0)
        }
    }

    fun basesAppend() {
        for (c in 0 until count) {
            sb.append(parameterMID.seq[seqPos + c])
            parameterMID.bases.add(sb.toString())
            sb.setLength(0)

            insertedIndexes.add(parameterMID.bases.size - 1)
        }
    }

    fun qualitiesAppend() {
        for (c in 0 until count) {
            parameterMID.qualities.add(qual[seqPos + c].code - 33)
        }
    }

    fun blockNumbersAppend() {
        for (c in 0 until count) {
            parameterMID.blockNumbers.add(parameterMID.blockNumber + c + 1)
        }
        parameterMID.blockNumber += count
    }

    fun partialIncrementsWithZeroAppend() {
        for (c in 0 until count) {
            parameterMID.partialIncrementsWithZero.add(partialIncrement + c + 1)
        }
    }

    fun returnShiftedParameterMID(): ParameterMID {
        return ParameterMID(
            parameterMID.yCoordinate,
            parameterMID.yCoordinates,
            parameterMID.positions,
            parameterMID.flag,
            parameterMID.directions,
            parameterMID.seq,
            parameterMID.pseudoReferenceForLegend,
            parameterMID.bases,
            parameterMID.qualities,
            parameterMID.blockNumber,
            parameterMID.blockNumbers,
            parameterMID.partialIncrementsWithZero)
    }

    fun returnShiftedSeqPos(): Int {
        seqPos += count
        return seqPos
    }

    fun returnShiftedRefPos(): Int {
        refPos += count
        return refPos
    }

    fun returnInsertedIndexes(): MutableList<Int> {
        return insertedIndexes
    }
}