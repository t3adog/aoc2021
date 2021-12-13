package day13

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput

internal class Day13KtTest {

    @Test
    fun part1() {
        assertEquals(17, part1(readInput("Day13", "Day13_test")))
    }

    @Test
    fun part2() {
        part2(readInput("Day13", "Day13_test"))
    }
}