package day12

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput

internal class Day12KtTest {

    @Test
    fun part1() {
        assertEquals(10, part1(readInput("day12", "Day12")))
    }

    @Test
    fun part2() {
        assertEquals(1, part2(readInput("day12", "Day12")))
    }
}