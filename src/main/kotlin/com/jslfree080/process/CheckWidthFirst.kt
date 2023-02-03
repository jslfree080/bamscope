package com.jslfree080.process

class CheckWidthFirst(private val width: Int) {
    fun fixedResult(): Boolean {
        return if (width !in 1..400) {
            System.err.println(
                "Width (current: $width) should be always positive value no more than 400!"
            )
            false
        } else {
            true
        }
    }
}