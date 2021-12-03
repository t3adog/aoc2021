package day03

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import readInput

internal class Day03KtTest {
    @Test
    fun part1() {
        val input = readInput("day03", "Day03_test")
        val result = part1(input)
        assertEquals(198, result)
    }

    @Test
    fun part2() {
        val input = readInput("day03", "Day03_test")
        val result = part2(input)
        assertEquals(900, result)
    }
}