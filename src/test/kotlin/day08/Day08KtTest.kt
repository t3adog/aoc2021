package day08

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput
import readInputToIntList

internal class Day08KtTest {

    @Test
    fun part1() {
        val input = readInput("day08", "Day08_test")
        assertEquals(26, part1(input))
    }

    @Test
    fun part2() {
        val input = readInput("day08", "Day08_test")
        assertEquals(61229, part2(input))
    }
}