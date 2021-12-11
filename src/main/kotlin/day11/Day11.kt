package day11

import readMutableMatrix

fun findNeighboursOctopus(input: MutableList<MutableList<Int>>, point: Pair<Int, Int>): MutableList<Pair<Int, Int>> {
    val y = point.first
    val x = point.second
    val neighbourOctopus = mutableListOf<Pair<Int, Int>>()
    // Текущая плоскость
    if (x - 1 > -1) {
        neighbourOctopus.add(Pair(y, x - 1))
    }
    if (x + 1 < input[y].size) {
        neighbourOctopus.add(Pair(y, x + 1))
    }
    // Заглядываем наверх
    if (y - 1 > -1) {
        neighbourOctopus.add(Pair(y - 1, x))
        if (x - 1 > -1) {
            neighbourOctopus.add(Pair(y - 1, x - 1))
        }
        if (x + 1 < input[y].size) {
            neighbourOctopus.add(Pair(y - 1, x + 1))
        }
    }
    // Смотрим вниз
    if (y + 1 < input.size) {
        neighbourOctopus.add(Pair(y + 1, x))
        if (x - 1 > -1) {
            neighbourOctopus.add(Pair(y + 1, x - 1))
        }
        if (x + 1 < input[y].size) {
            neighbourOctopus.add(Pair(y + 1, x + 1))
        }
    }
    return neighbourOctopus
}

fun findOctopusesForFlash(input: MutableList<MutableList<Int>>): MutableList<Pair<Int, Int>> {
    val foundOctopuses = mutableListOf<Pair<Int, Int>>()
    for (y in input.indices) {
        for (x in input[y].indices) {
            if (input[y][x] > 9) {
                foundOctopuses.add(Pair(y, x))
            }
        }
    }
    return foundOctopuses
}

fun flashOctopus(
    input: MutableList<MutableList<Int>>,
    octopusesForFlash: MutableList<Pair<Int, Int>>,
    flashedOctopuses: MutableSet<Pair<Int, Int>>
) {
    for (octopus in octopusesForFlash) {
        if (octopus in flashedOctopuses) {
            continue
        }
        input[octopus.first][octopus.second] = 0
        flashedOctopuses.add(octopus)
        for (neighbourOctopus in findNeighboursOctopus(input, octopus)) {
            if (neighbourOctopus in flashedOctopuses) {
                continue
            }
            if (input[neighbourOctopus.first][neighbourOctopus.second] < 9) {
                input[neighbourOctopus.first][neighbourOctopus.second] += 1
            } else {
                flashOctopus(input, mutableListOf(neighbourOctopus), flashedOctopuses)
            }
        }
    }
}

fun part1(input: MutableList<MutableList<Int>>): Int {
    var flashCount = 0
    for (step in 0..99) {
        for (y in input.indices) {
            for (x in input[y].indices) {
                input[y][x] += 1
            }
        }
        val flashedOctopuses = mutableSetOf<Pair<Int, Int>>()
        while (findOctopusesForFlash(input).filter { it !in flashedOctopuses }.isNotEmpty()) {
            flashOctopus(input, findOctopusesForFlash(input), flashedOctopuses)
        }
        flashCount += flashedOctopuses.size

    }
    return flashCount
}

fun part2(input: MutableList<MutableList<Int>>): Int {
    var step = 0
    while (input.flatten().count {it == 0} < input.flatten().count()) {
        for (y in input.indices) {
            for (x in input[y].indices) {
                input[y][x] += 1
            }
        }
        val flashedOctopuses = mutableSetOf<Pair<Int, Int>>()
        while (findOctopusesForFlash(input).filter { it !in flashedOctopuses }.isNotEmpty()) {
            flashOctopus(input, findOctopusesForFlash(input), flashedOctopuses)
        }
        step++
    }
    return step
}

fun main() {
    println(part1(readMutableMatrix("day11", "Day11")))
    println(part2(readMutableMatrix("day11", "Day11")))
}