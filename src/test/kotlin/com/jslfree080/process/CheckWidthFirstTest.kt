package com.jslfree080.process

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CheckWidthFirstTest {
    @Test
    fun testFixedResult() {
        val checkWidthFirst = CheckWidthFirst(50)
        val result = checkWidthFirst.fixedResult()
        assertTrue(result)
    }
}