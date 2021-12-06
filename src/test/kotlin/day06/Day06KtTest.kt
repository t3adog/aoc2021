package day06

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput

internal class Day06KtTest {

    @Test
    fun part1() {
        val input = readInput("day06", "Day06_test")
        val result = part1(input[0])
        assertEquals(5934, result)
    }

    @Test
    fun part2() {
        val input = readInput("day06", "Day06_test")
        val result = part2(input[0])
        assertEquals(26984457539, result)
    }
}