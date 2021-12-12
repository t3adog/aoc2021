package day12

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput

internal class Day12KtTest {

    @Test
    fun part1() {
        assertEquals(19, part1(readInput("day12", "Day12_test")))
    }

    @Test
    fun part2() {
        assertEquals(103, part2(readInput("day12", "Day12_test")))
    }
}