package day02

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import readInput

internal class Day02KtTest {

    @Test
    fun part1() {
        val input = readInput("day02", "Day02_test")
        val result = day02.part1(input)
        assertEquals(150, result)
    }

    @Test
    fun part2() {
        val input = readInput("day02", "Day02_test")
        val result = day02.part2(input)
        assertEquals(150, result)
    }
}