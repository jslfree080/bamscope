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

import com.jslfree080.process.BlockAdjustment
import com.jslfree080.process.ExtractReference
import picocli.CommandLine
import com.jslfree080.process.RunSamtools
import com.jslfree080.process.ParseRead

@CommandLine.Command(name = "bamscope", version = ["bamscope 0.4.0"],
    description = ["A command line tool (in Kotlin/JVM) for visualizing BAM alignments."])
class BAMScopeCommand : Runnable {

    @CommandLine.Parameters(index = "0", description = ["Input chromosomal position.      ex) (chr)N:XXXXXXXX"])
    private lateinit var chrPos: String

    @CommandLine.Parameters(index = "1", description = ["Path to an input bam file.       ex) path/to/x.bam"])
    private lateinit var bamPath: String

    @CommandLine.Option(names = ["-h", "--help"], usageHelp = true, description = ["Show this help message and exit."])
    private var help = false

    @CommandLine.Option(names = ["-o", "--outPath"], description = ["Path to an output image.                 default) ."])
    private var outPath = "."

    @CommandLine.Option(names = ["-r", "--refPath"], description = ["Path to a reference fasta.       ex) path/to/x.fasta"])
    private var refPath = "noReferencePath"

    @CommandLine.Option(names = ["-w", "--width"], description = ["Width of start to interest position.     default) 50"])
    private var width = 50

    override fun run() {
        val runSamtools = RunSamtools(chrPos, bamPath, width, refPath)
        val parseRead = ParseRead(runSamtools.samtoolsViewLines)
        parseRead.appender()
        val blockAdjustment = BlockAdjustment(
            parseRead.positions,
            parseRead.blockNumbers,
            parseRead.partialIncrementsWithZero,
            parseRead.insertedIndexes
        )
        blockAdjustment.generateOutputForGap()
        if (runSamtools.samtoolsFaidxPair.isNotEmpty()) {
            val extractReference = ExtractReference(blockAdjustment.pairForShift, runSamtools.samtoolsFaidxPair)
            println(extractReference.returnBasesRef())
        }
    }
}