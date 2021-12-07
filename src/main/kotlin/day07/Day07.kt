package day07

import readInput
import readInputToIntList

fun part1(input: List<Int>): Int {
    val maxValue = input.maxOrNull() ?: 0
    val minValue = input.minOrNull() ?: 0

    val log = mutableMapOf<Int, Int>()
    for (index: Int in minValue..maxValue) {
        var sum = 0
        for (crab in input) {
            if (index > 0) {
                if (crab > index) {
                    sum += (crab - index)
                }
                if (crab < index) {
                    sum += (index - crab)
                }
                if (crab == index) {
                    continue
                }
            }
            if (index == 0) {
                sum += crab
            }
        }
        log.put(index, sum)
    }
    return log.values.minOrNull() ?: 0
}

fun part2(input: List<Int>): Int {
    return 0
}

fun main() {
    val input = readInputToIntList("day07", "Day07")
    println(part1(input))
    println(part2(input))
}