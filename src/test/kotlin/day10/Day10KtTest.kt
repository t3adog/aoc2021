package day10

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput

internal class Day10KtTest {

    @Test
    fun part1() {
        val input = readInput("day10", "Day10_test")
        assertEquals(26397, part1(input))
    }

    @Test
    fun part2() {
        val input = readInput("day10", "Day10_test")
        assertEquals(10, part2(input))
    }
}