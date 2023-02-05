package com.jslfree080.process

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class CheckWidthAgainTest {
    @Test
    fun testExpDecayResult() {
        val checkWidthAgain = CheckWidthAgain(50, mutableListOf(1))
        val result = checkWidthAgain.expDecayResult()
        assertTrue(result)
    }
}