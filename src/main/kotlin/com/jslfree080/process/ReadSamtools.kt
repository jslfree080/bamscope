package com.jslfree080.process

enum class ReadSamtools(private val samtoolsCommand: String) {
    VIEW("view"), FAIDX("faidx");

    fun processToLines(filePath: String, chr: String, pos1: String, pos2: String): List<String> {
        val samtoolsProcess: Process = ProcessBuilder("samtools", samtoolsCommand, filePath, "$chr:$pos1-$pos2")
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .start()
        val samtoolsOutput = samtoolsProcess.inputStream.bufferedReader().use { it.readText() }
        return samtoolsOutput.split("\n")
    }
}