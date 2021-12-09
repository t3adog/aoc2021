package day09

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readMatrix

internal class Day09KtTest {

    @Test
    fun part1() {
        val input = readMatrix("day09", "Day09_test")
        assertEquals(15, part1(input))
    }

    @Test
    fun part2() {
        val input = readMatrix("day09", "Day09_test")
        assertEquals(1134, part2(input))
    }
}