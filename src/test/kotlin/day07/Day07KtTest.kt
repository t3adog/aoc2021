package day07

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput
import readInputToIntList

internal class Day07KtTest {

    @Test
    fun part1() {
        val input = readInputToIntList("day07", "Day07_test")
        val result = part1(input)
        assertEquals(37, result)
    }

    @Test
    fun part2() {
        val input = readInputToIntList("day07", "Day07_test")
        val result = part2(input)
        assertEquals(168, result)
    }
}