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

@CommandLine.Command(name = "bamscope", version = ["bamscope 0.0.2"],
    description = ["A command line tool (in Kotlin/JVM) for visualizing BAM alignments."])
class BAMScopeCommand : Runnable {

    @CommandLine.Parameters(index = "0", description = ["Input chromosomal position. ex) chrN:XXXXXXXX"])
    private lateinit var chrPos: String

    @CommandLine.Parameters(index = "1", description = ["Path to an input bam file. ex) path/to/xxx.bam"])
    private lateinit var bamPath: String

    @CommandLine.Option(names = ["-help"], usageHelp = true, description = ["Show this help message and exit."])
    private var help = false

    @CommandLine.Option(names = ["-ref"], description = ["Path to a reference fasta. ex) path/to/xxx.fasta"])
    private lateinit var refFile: String

    @CommandLine.Option(names = ["-width"], description = ["Width of chromosomal range. default) 50"])
    private var widthRange: Int = 50

    override fun run() {
        println("Welcome to bamscope!")
        println(chrPos)
        println(bamPath)
        println(help)
        println(refFile)
        println(widthRange)
    }
}