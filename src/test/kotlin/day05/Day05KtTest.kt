package day05

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import readInput

internal class Day05KtTest {

    @Test
    fun part1() {
        val input = readInput("day05", "Day05_test")
        val result = part1(input)
        assertEquals(5, result)
    }

    @Test
    fun part2() {
        val input = readInput("day05", "Day05_test")
        val result = part1(input)
        assertEquals(0, result)
    }

}