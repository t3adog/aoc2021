package day09

import readMatrix

fun isLeast(y: Int, x: Int, matrix: List<List<Int>>): Boolean {
    var neighbours = mutableListOf<Int>()
    if (y - 1 > -1) {
        neighbours.add(matrix[y - 1][x])
    }
    if (y + 1 < matrix.size) {
        neighbours.add(matrix[y + 1][x])
    }
    if (x - 1 > -1) {
        neighbours.add(matrix[y][x - 1])
    }
    if (x + 1 < matrix[y].size) {
        neighbours.add(matrix[y][x + 1])
    }
    return matrix[y][x] < (neighbours.minOrNull() ?: 0)
}

fun part1(input: List<List<Int>>): Int {
    val minimalValues = mutableListOf<Int>()

    for (y: Int in 0..input.size - 1) {
        for (x: Int in 0..input[y].size - 1) {
            if (isLeast(y, x, input)) {
                minimalValues.add(input[y][x])
            }
        }
    }
    return minimalValues.map { it + 1 }.sum()
}

fun part2(input: List<List<Int>>): Int {
    return 0
}

fun main() {
    val input = readMatrix("day09", "Day09")
    println(part1(input))
    println(part2(input))
}