package com.jslfree080.process

import kotlin.math.*

class BlockAdjustment(positions: MutableList<Int>,
                      partialIncrementsWithZero: MutableList<Int>,
                      insertedIndexes: MutableList<Int>) {
    private val insertedPositions = insertedIndexes.map { positions[it] }
    private val partialIncrements = insertedIndexes.map { partialIncrementsWithZero[it] }
    private val insertedPositionsStart = insertedPositions.zip(partialIncrements)
        .filter { (_, list2) -> list2 == 1 }
        .map { (list1, _) -> list1 }
    private val newPositions = mutableListOf<Int>()
    private var posIndex = 0
    private val outputForGap = mutableListOf<Int>()

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
        val dictForShift = (insertedPositionsStart.toSet().toList()).zip(outputForGap)
        println(dictForShift)
    }
}