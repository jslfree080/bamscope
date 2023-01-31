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

import com.jslfree080.process.cigars.*

class ParseRead(samtoolsViewLines: List<String>) {
    // Parse the output to extract the read positions and bases
    private val nonEmptyLines = samtoolsViewLines.filter { it.isNotEmpty() }

    private var yCoordinate = 50
    private var yCoordinates = mutableListOf<Int>()
    var positions = mutableListOf<Int>()
    private var directions = mutableListOf<String>()
    private var pseudoReferenceForLegend = mutableListOf<String>()
    private var bases = mutableListOf<String>()
    private var qualities = mutableListOf<Int>()
    var blockNumbers = mutableListOf<Int>()
    var partialIncrementsWithZero = mutableListOf<Int>()
    var insertedIndexes = mutableListOf<Int>()

    fun appender() {
        val sb = StringBuilder()

        nonEmptyLines.forEach {
            val fields = it.split("\t")

            yCoordinate += 100
            val flag = fields[1].toInt()
            val seq: String = fields[9]
            val blockNumber = 0
            var seqPos = 0
            var refPos = fields[3].toInt()
            val qual: String = fields[10]

            val cigarString: String = fields[5]
            val match = Regex("""(\d+)([MIDNSHP=X])""").findAll(cigarString)

            var parameterMID = ParameterMID(
                yCoordinate,
                yCoordinates,
                positions,
                flag,
                directions,
                seq,
                pseudoReferenceForLegend,
                bases,
                qualities,
                blockNumber,
                blockNumbers,
                partialIncrementsWithZero)
            val cigarM = CigarMatch(sb, parameterMID, seqPos, refPos, qual)
            val cigarI = CigarInsertion(sb, parameterMID, seqPos, refPos, qual, insertedIndexes)
            val cigarD = CigarDeletion(sb, parameterMID, seqPos, refPos)
            val cigarS = CigarSoftClip(seqPos)
            val cigarN = CigarSkippedRegion(refPos)
            val cigarP = CigarPadding(refPos)

            for (m in match) {
                val count = m.groupValues[1].toInt()
                when (m.groupValues[2]) {
                    "M", "=", "X" -> {
                        cigarM.count = count
                        cigarM.partialIncrement = 0
                        cigarM.parameterMID = parameterMID
                        cigarM.seqPos = seqPos
                        cigarM.refPos = refPos
                        cigarM.qual = qual

                        cigarM.commonAppend()
                        cigarM.pseudoReferenceForLegendAppend()
                        cigarM.basesAppend()
                        cigarM.qualitiesAppend()
                        cigarM.blockNumbersAppend()
                        cigarM.partialIncrementsWithZeroAppend()

                        parameterMID = cigarM.returnShiftedParameterMID()
                        seqPos = cigarM.returnShiftedSeqPos()
                        refPos = cigarM.returnShiftedRefPos()
                    }
                    "I" -> {
                        cigarI.count = count
                        cigarI.partialIncrement = 0
                        cigarI.parameterMID = parameterMID
                        cigarI.seqPos = seqPos
                        cigarI.refPos = refPos
                        cigarI.qual = qual
                        cigarI.insertedIndexes = insertedIndexes

                        cigarI.commonAppend()
                        cigarI.pseudoReferenceForLegendAppend()
                        cigarI.basesAppend()
                        cigarI.qualitiesAppend()
                        cigarI.blockNumbersAppend()
                        cigarI.partialIncrementsWithZeroAppend()

                        parameterMID = cigarI.returnShiftedParameterMID()
                        seqPos = cigarI.returnShiftedSeqPos()
                        refPos = cigarI.returnShiftedRefPos()
                        insertedIndexes = cigarI.returnInsertedIndexes()
                    }
                    "D" -> {
                        cigarD.count = count
                        cigarD.partialIncrement = 0
                        cigarD.parameterMID = parameterMID
                        cigarD.seqPos = seqPos
                        cigarD.refPos = refPos

                        cigarD.commonAppend()
                        cigarD.pseudoReferenceForLegendAppend()
                        cigarD.basesAppend()
                        cigarD.qualitiesAppend()
                        cigarD.blockNumbersAppend()
                        cigarD.partialIncrementsWithZeroAppend()

                        parameterMID = cigarD.returnShiftedParameterMID()
                        refPos = cigarD.returnShiftedRefPos()
                    }
                    "S" -> {
                        cigarS.count = count
                        cigarS.seqPos = seqPos

                        seqPos = cigarS.returnShiftedSeqPos()
                    }
                    "H" -> {  }
                    "N" -> {
                        cigarN.count = count
                        cigarN.refPos = refPos

                        refPos = cigarN.returnShiftedRefPos()
                    }
                    "P" -> {
                        cigarP.count = count
                        cigarP.refPos = refPos

                        refPos = cigarP.returnShiftedRefPos()
                    }
                }
            }
        }
    }
}