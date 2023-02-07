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

package com.jslfree080.cli

import picocli.CommandLine
import com.jslfree080.process.*

@CommandLine.Command(name = "bamscope", version = ["bamscope 1.0.0"],
    description = ["A command line tool (in Kotlin/JVM) for visualizing BAM alignments."])
class BAMScopeCommand : Runnable {

    @CommandLine.Parameters(index = "0", description = ["Input chromosomal position.      ex) (chr)N:XXXXXXXX"])
    private lateinit var chrPos: String

    @CommandLine.Parameters(index = "1", description = ["Path to an indexed bam file.       ex) path/to/x.bam"])
    private lateinit var bamPath: String

    @CommandLine.Option(names = ["-f", "--format"], description = ["File format of an output image.         default) png"])
    private var format = "png"

    @CommandLine.Option(names = ["-h", "--help"], usageHelp = true, description = ["Show this help message and exit."])
    private var help = false

    @CommandLine.Option(names = ["-o", "--outPath"], description = ["Path to an output image.                  default) ."])
    private var outPath = "."

    @CommandLine.Option(names = ["-r", "--refPath"], description = ["Path to a reference fasta.       ex) path/to/x.fasta"])
    private var refPath = "noReferencePath"

    @CommandLine.Option(names = ["-s", "--sPath"], description = ["Path to the samtools.    ex) /usr/local/bin/samtools"])
    private var sPath = "samtools"

    @CommandLine.Option(names = ["-w", "--width"], description = ["Width of start to interest position.     default) 50"])
    private var width = 50

    override fun run() {
        val bamFile = bamPath.split("[/\\\\]".toRegex()).last()
        val checkWidthFirst = CheckWidthFirst(width)
        if (!checkWidthFirst.fixedResult()) { return }
        val runSamtools = RunSamtools(chrPos, bamPath, width, refPath, sPath)
        val parseRead = ParseRead(runSamtools.samtoolsViewLines)
        parseRead.appender()
        val checkWidthAgain = CheckWidthAgain(width, parseRead.yCoordinates)
        if (!checkWidthAgain.expDecayResult()) { return }
        val blockAdjustment = BlockAdjustment(
            parseRead.positions,
            parseRead.blockNumbers,
            parseRead.partialIncrementsWithZero,
            parseRead.insertedIndexes
        )
        blockAdjustment.generateOutputForGap()

        var newSamtoolsMap = emptyList<Pair<Int, String>>()
        var basesRef = emptyList<String>()
        if (runSamtools.samtoolsFaidxPair.isNotEmpty()) {
            val extractReference = ExtractReference(blockAdjustment.pairForShift, runSamtools.samtoolsFaidxPair)
            basesRef = extractReference.returnBasesRef()
            newSamtoolsMap = extractReference.newSamtoolsMap
        }
        val plotAlignment = PlotAlignment(
            blockAdjustment.newPositions,
            newSamtoolsMap,
            parseRead.yCoordinates,
            parseRead.bases,
            parseRead.pseudoReferenceForLegend,
            basesRef,
            parseRead.qualities,
            parseRead.directions,
            blockAdjustment.pairForShift,
            runSamtools.chr,
            runSamtools.intPos,
            runSamtools.startPos,
            runSamtools.endPos,
            bamFile,
            format,
            outPath)
        plotAlignment.letsPlot()
    }
}