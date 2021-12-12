package day12

import readInput

// borrowed this solution from @anisch

fun parseSignals(input: List<String>): Set<Pair<String, String>> {
    return input.map { it.split("-") }.map { Pair(it[0], it[1]) }.toSet()
}

fun findPathsForPart1(path: List<String>, signals: Set<Pair<String, String>>): Set<List<String>> {
    val currentCave = path.last()
    if (currentCave == "end")
        return setOf(path)

    val forbiddenNeighbors = path.filter { it.first().isLowerCase() }
    val neighborCaves = signals.filter { it.first == currentCave || it.second == currentCave }
        .map { if (it.first == currentCave) it.second else it.first }.filter { !forbiddenNeighbors.contains(it) }
    return neighborCaves.flatMap { findPathsForPart1(path + it, signals) }.toSet()
}

fun findPathsForPart2(path: List<String>, signals: Set<Pair<String, String>>): Set<List<String>> {
    val currentCave = path.last()
    if (currentCave == "end")
        return setOf(path)

    val previousCaveVisits: MutableMap<String, Int> = mutableMapOf()
    path.forEach { previousCaveVisits[it] = (previousCaveVisits[it] ?: 0) + 1 }
    val smallCaveWasVisitedTwice =
        previousCaveVisits.filter { it.key != "start" && it.key.first().isLowerCase() && it.value > 1 }
            .isNotEmpty()
    val forbiddenNeighbors =
        path.filter { it == "start" || (it.first().isLowerCase() && smallCaveWasVisitedTwice) }
    val neighborCaves = signals.filter { it.first == currentCave || it.second == currentCave }
        .map { if (it.first == currentCave) it.second else it.first }.filter { !forbiddenNeighbors.contains(it) }
    return neighborCaves.flatMap { findPathsForPart2(path + it, signals) }.toSet()
}

fun part1(input: List<String>): Int {
    return findPathsForPart1(mutableListOf("start"), parseSignals(input)).size
}

fun part2(input: List<String>): Int {
    return findPathsForPart2(mutableListOf("start"), parseSignals(input)).size
}

fun main() {
    println(part1(readInput("day12", "Day12")))
    println(part2(readInput("day12", "Day12")))
}