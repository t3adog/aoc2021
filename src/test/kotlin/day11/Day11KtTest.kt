package day11

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import readInput

internal class Day11KtTest {

    var input = emptyList<String>()

    @BeforeEach
    fun init() {
        input = readInput("day11", "Day11_test")
    }

    @Test
    fun part1() {
        assertEquals(0, part1(input))
    }

    @Test
    fun part2() {
        assertEquals(0, part2(input))
    }
}