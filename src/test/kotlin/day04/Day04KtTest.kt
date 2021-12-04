package day04

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import readInput

internal class Day04KtTest {

    @Test
    fun part1() {
        val input = readInput("day04", "Day04_test")
        val result = part1(input)
        assertEquals(4512, result)
    }

    @Test
    fun part2() {
        val input = readInput("day04", "Day04_test")
        val result = part2(input)
        assertEquals(0, result)
    }
}