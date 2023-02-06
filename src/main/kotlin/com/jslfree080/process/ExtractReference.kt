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

class ExtractReference(pairForShift: List<Pair<Int, Int>>,
                       private val samtoolsFaidxPair: List<Pair<Int, String>>) {
    private val pairForShiftSorted = pairForShift.sortedBy { it.first }
    var newSamtoolsMap = emptyList<Pair<Int, String>>()
    private var refReader = 0
    private var adder = 0
    private var incrementer = 0

    fun returnBasesRef(): List<String> {
        (pairForShiftSorted.indices).forEach {
            while (samtoolsFaidxPair
                    .map { (list1, _) -> list1 }[refReader]
                <
                pairForShiftSorted
                    .map { (list1, _) -> list1 }[it]) {
                newSamtoolsMap = newSamtoolsMap +
                        samtoolsFaidxPair
                            .filter { (list1, _) -> list1 == samtoolsFaidxPair.map { (list1, _) -> list1 }[refReader] }
                            .map { (list1, list2) -> list1 + adder to list2 }
                refReader += 1
                if (samtoolsFaidxPair.map { (list1, _) -> list1 }[refReader] ==
                    pairForShiftSorted.map { (list1, _) -> list1 }[it]) { break }
            }
            for (idx in 0 until pairForShiftSorted.map { (_, list2) -> list2 }[it]) {
                incrementer = adder
                newSamtoolsMap = newSamtoolsMap +
                        listOf(pairForShiftSorted.map { (list1, _) -> list1 }[it] + incrementer).zip(listOf("gap"))
                adder += 1
            }
        }
        while (true) {
            try {
                newSamtoolsMap = newSamtoolsMap +
                        samtoolsFaidxPair
                            .filter { (list1, _) -> list1 == samtoolsFaidxPair.map { (list1, _) -> list1 }[refReader] }
                            .map { (list1, list2) -> list1 + adder to list2 }
                refReader += 1
            } catch (_: IndexOutOfBoundsException) { break }
        }
        return newSamtoolsMap.map { (_, list2) -> list2 }
    }
}