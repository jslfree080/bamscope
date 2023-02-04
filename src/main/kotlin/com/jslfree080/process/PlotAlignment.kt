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

import org.jetbrains.letsPlot.*
import org.jetbrains.letsPlot.label.ggtitle
import org.jetbrains.letsPlot.geom.*
import org.jetbrains.letsPlot.themes.theme
import org.jetbrains.letsPlot.scale.*
import org.jetbrains.letsPlot.export.*
import kotlin.math.exp

class PlotAlignment(private val newPositions: MutableList<Int>,
                    newSamtoolsMap: List<Pair<Int, String>>,
                    private val yCoordinates: MutableList<Int>,
                    private val bases: MutableList<String>,
                    private val pseudoReferenceForLegend: MutableList<String>,
                    private val basesRef: List<String>,
                    private val qualities: MutableList<Int>,
                    private val pairForShift: List<Pair<Int, Int>>,
                    private val chr: String,
                    private val intPos: String,
                    private val startPos: String,
                    private val endPos: String) {
    // normalize qualities to [0, 1]
    private val alpha: MutableList<Double> = qualities
        .map { it.toDouble() / qualities.max().toDouble() } as MutableList<Double>

    private val data = mapOf(
        "x" to newPositions,
        "y" to yCoordinates,
        "c" to bases,
        "cz" to pseudoReferenceForLegend,
        "quality" to alpha
    )

    private val dataRef = mapOf(
        "xRef" to newSamtoolsMap.map { (list1, _) -> list1 },
        "yRef" to List(newSamtoolsMap.map { (list1, _) -> list1 }.size) {-2},
        "cRef" to basesRef
    )

    // shift position of interest
    private val shiftPositionOfInterest = pairForShift
        .filter { (list1, _) -> list1 <= intPos.toInt() }
        .sumOf { (_, list2) -> list2 }

    private val legendInterestIndices = newPositions
        .indices.filter { newPositions[it] >= startPos.toInt() && newPositions[it] <= endPos.toInt() }

    private var baseColors = listOf("#DC143C", "#1E90FF", "#32CD32", "#FFD700", "#FFFFFF", "#1A2421", "#696969")
        .zip(listOf("A", "C", "G", "T", "del", "gap", "N")).toMap()

    fun letsPlot() {
        // legend adjustment
        if ("A" !in (legendInterestIndices.map { bases[it] }))
        { baseColors = baseColors - "#DC143C" }
        if ("C" !in (legendInterestIndices.map { bases[it] }))
        { baseColors = baseColors - "#1E90FF" }
        if ("G" !in (legendInterestIndices.map { bases[it] }))
        { baseColors = baseColors - "#32CD32" }
        if ("T" !in (legendInterestIndices.map { bases[it] }))
        { baseColors = baseColors - "#FFD700" }
        if ("del" !in (legendInterestIndices.map { bases[it] }))
        { baseColors = baseColors - "#FFFFFF" }
        if ("gap" !in (legendInterestIndices.map { pseudoReferenceForLegend[it] }))
        { baseColors = baseColors - "#1A2421" }
        if ("N" !in (legendInterestIndices.map { bases[it] }))
        { baseColors = baseColors - "#696969" }

        // quality adjustment for del and N
        bases
            .mapIndexedNotNull { index, base -> if (listOf("del", "N").contains(base)) index else null }
            .forEach { alpha[it] = 1.0 }

        // create scatter plot
        val p = ggplot(data) +
                ggtitle("$chr:$intPos") +
                geomVLine(
                    xintercept = intPos.toInt() + shiftPositionOfInterest,
                    color = "#FFFFFF",
                    size = 0.5 * exp(-0.0048 * (yCoordinates.max() + 2))
                ) +
                geomHLine(
                    yintercept = -1,
                    color = "#FFFFFF",
                    size = 0.5 * exp(-0.0048 * (yCoordinates.max() + 2))
                ) +
                geomPoint(
                    shape = 15,
                    size = 2.2 * exp(-0.0048 * (yCoordinates.max() + 2))
                )
                { x = "x"; y = "y"; color = "c"; alpha = "quality" } +
                org.jetbrains.letsPlot.themes.themeLight() +
                theme(
                    panelBackground = org.jetbrains.letsPlot.themes.elementRect(fill = "#1A2421", color = "#1A2421"),
                    text = org.jetbrains.letsPlot.themes.elementText(family = "Helvetica"),
                    panelGridMinor = "blank",
                    panelGridMajor = "blank",
                    axisTicks = "blank",
                    axisText = "blank",
                    axisTitle = "blank",
                    legendBackground = org.jetbrains.letsPlot.themes.elementRect(fill = "#EDEDED")
                ) +
                scaleColorManual(
                    name = "Base",
                    values = baseColors.keys.toList(),
                    breaks = baseColors.values.toList()
                ) +
                org.jetbrains.letsPlot.coord.coordFixed(
                    ratio = 1,
                    xlim = Pair(startPos.toInt() - 0.5, endPos.toInt() + 0.5),
                    ylim = Pair(-1.5, yCoordinates.max() + 0.5)
                ) +
                guides(alpha = "none")

        // show the plot
        // p.show()

        // save the plot
        ggsave(p, "example.png", 9.9, 600, "/Users/jslit/Downloads")
    }
}