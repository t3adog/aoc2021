package day07

import readInputToIntList

fun part1(input: List<Int>): Int {
    val maxValue = input.maxOrNull() ?: 0
    val minValue = input.minOrNull() ?: 0

    val log = mutableMapOf<Int, Int>()
    for (index: Int in minValue..maxValue) {
        var sum = 0
        for (crab in input) {
            sum += calculateDistance(crab, index)
        }
        log.put(index, sum)
    }
    return log.values.minOrNull() ?: 0
}

fun calculateDistance(crabPosition: Int, horizontalPosition: Int): Int {
    return if (horizontalPosition == 0) {
        crabPosition
    } else if (horizontalPosition > crabPosition) {
        horizontalPosition - crabPosition
    } else {
        crabPosition - horizontalPosition
    }
}

fun calculateFuelConsumption(distance: Int): Int {
    var finalSum = 0
    for (x: Int in 0..distance) {
        finalSum += x
    }
    return finalSum
}

fun part2(input: List<Int>): Int {
    val maxValue = input.maxOrNull() ?: 0
    val minValue = input.minOrNull() ?: 0

    val log = mutableMapOf<Int, Int>()
    for (index: Int in minValue..maxValue) {
        var sum = 0
        for (crab in input) {
            sum += calculateFuelConsumption(calculateDistance(crab, index))
        }
        log.put(index, sum)
    }
    return log.values.minOrNull() ?: 0
}

fun main() {
    val input = readInputToIntList("day07", "Day07")
    println(part1(input))
    println(part2(input))
}