package day14

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput

internal class Day14KtTest {

    @Test
    fun part1() {
        assertEquals(1588, part1(readInput("Day14", "Day14_test")))
    }

    @Test
    fun part2() {
        assertEquals(2188189693529, part2(readInput("Day14", "Day14_test")))
    }
}