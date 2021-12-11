package day11

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

import readMutableMatrix

internal class Day11KtTest {

    @Test
    fun part1() {
        assertEquals(1656, part1(readMutableMatrix("day11", "Day11_test")))
    }

    @Test
    fun part2() {
        assertEquals(0, part2(readMutableMatrix("day11", "Day11_test")))
    }
}