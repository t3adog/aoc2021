package day09

import readMatrix

fun isLeast(point: Pair<Int, Int>, input: List<List<Int>>): Boolean {
    return input[point.first][point.second] < (findNeighboursPoints(input, point).map { input[it.first][it.second] }
        .minOrNull() ?: 0)
}

fun findSingleLowPoints(input: List<List<Int>>): List<Pair<Int, Int>> {
    val minimalPoints = mutableListOf<Pair<Int, Int>>()

    for (y: Int in 0..input.size - 1) {
        for (x: Int in 0..input[y].size - 1) {
            val point = Pair(y, x)
            if (isLeast(point, input)) {
                minimalPoints.add(point)
            }
        }
    }
    return minimalPoints
}

fun findNeighboursPoints(input: List<List<Int>>, point: Pair<Int, Int>): List<Pair<Int, Int>> {
    val y = point.first
    val x = point.second
    val neighbours = mutableListOf<Pair<Int, Int>>()
    if (y - 1 > -1) {
        neighbours.add(Pair(y - 1, x))
    }
    if (y + 1 < input.size) {
        neighbours.add(Pair(y + 1, x))
    }
    if (x - 1 > -1) {
        neighbours.add(Pair(y, x - 1))
    }
    if (x + 1 < input[y].size) {
        neighbours.add(Pair(y, x + 1))
    }
    return neighbours
}

fun findBasins(input: List<List<Int>>): List<Int> {
    val minimalPoints = findSingleLowPoints(input)
    val basins = mutableListOf<Int>()
    for (point in minimalPoints) {
        val foundPoints = mutableSetOf<Pair<Int, Int>>()
        foundPoints.add(point)

        while (true) {
            val size = foundPoints.size
            val found = mutableListOf<Pair<Int, Int>>()
            for (foundPoint in foundPoints) {
                found.addAll(findNeighboursPoints(input, foundPoint).filter { input[it.first][it.second] != 9 })
            }
            foundPoints.addAll(found)
            if (size == foundPoints.size) {
                break
            }
        }
        basins.add(foundPoints.size)
    }
    return basins
}

fun part1(input: List<List<Int>>): Int {
    return findSingleLowPoints(input).map { input[it.first][it.second] }.map { it + 1 }.sum()
}

fun part2(input: List<List<Int>>): Int {
    val basins = findBasins(input).sorted()
    return basins[basins.size - 1] * basins[basins.size - 2] * basins[basins.size - 3]
}

fun main() {
    val input = readMatrix("day09", "Day09")
    println(part1(input))
    println(part2(input))
}