package day1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import readInput

internal class Day01KtTest {

    @Test
    fun testPart1() {
        val input = readInput("day1", "Day01_test")
        val result = part1(input)
        assertEquals(7, result)
    }

    @Test
    fun testPart2() {
        val input = readInput("day1", "Day01_test")
        val result = part2(input)
        assertEquals(5, result)
    }
}