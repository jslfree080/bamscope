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

class RunSamtools(chrPos: String, bamPath: String, width: Int, refPath: String) {
    val chr = chrPos.split(":")[0]
    val intPos = chrPos.split(":")[1]
    val startPos = (intPos.toInt() - width).toString()
    val endPos = (intPos.toInt() + width).toString()
    // Run samtools to extract the reads within the specified region
    val samtoolsViewLines = ReadSamtools.VIEW.processToLines(bamPath, chr, startPos, endPos)
    // Run samtools to extract the reference sequence
    private val extraPos = (2 * endPos.toInt() - startPos.toInt()).toString()
    val samtoolsFaidxLines = if (refPath == "noReferencePath") listOf("noReferencePath")
    else ReadSamtools.FAIDX.processToLines(refPath, chr, startPos, extraPos)
    // properties to be updated: samtoolsFaidxString, samtoolsFaidxDict
}