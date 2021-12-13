package day13

import readInput

fun parsePoints(input: List<String>): Set<Pair<Int, Int>> {
    return input
        .filter { !it.contains("fold along") }
        .filter { it.length > 0 }
        .map { it.split(",").map { it.toInt() }.let { (x, y) -> Pair(x, y) } }.toSet()
}

fun parseInstructions(input: List<String>): List<Pair<String, Int>> {
    val commands = mutableListOf<Pair<String, Int>>()

    for (line in input.filter { it.contains("fold along") }) {
        if (line.contains("x")) {
            commands.add(Pair("x", line.split("=")[1].toInt()))
        } else {
            commands.add(Pair("y", line.split("=")[1].toInt()))
        }
    }
    return commands
}

fun foldInstruction(instruction: Pair<String, Int>, points: Set<Pair<Int, Int>>): Set<Pair<Int, Int>> {
    when (instruction.first) {
        "x" -> return foldByX(points, instruction.second)
        "y" -> return foldByY(points, instruction.second)
    }
    return points
}

fun foldByX(input: Set<Pair<Int, Int>>, x: Int): Set<Pair<Int, Int>> {
    val result = mutableSetOf<Pair<Int, Int>>()

    for (point in input) {
        if (point.first > x) {
            result.add(Pair(2 * x - point.first, point.second))
        } else {
            result.add(point)
        }
    }

    return result
}

fun foldByY(input: Set<Pair<Int, Int>>, y: Int): Set<Pair<Int, Int>> {
    val result = mutableSetOf<Pair<Int, Int>>()

    for (point in input) {
        if (point.second > y) {
            result.add(Pair(point.first, 2 * y - point.second))
        } else {
            result.add(point)
        }
    }

    return result
}

fun part1(input: List<String>): Int {
    var points = parsePoints(input)

    val foldInstruction = parseInstructions(input)[0]

    return foldInstruction(foldInstruction, points).size
}

fun part2(input: List<String>) {
    var points = parsePoints(input)

    val foldInstructions = parseInstructions(input)

    for (foldInstruction in foldInstructions) {
        points = foldInstruction(foldInstruction, points)
    }

    val maxX = points.map { it.first }.maxOrNull() ?: 0
    val maxY = points.map { it.second }.maxOrNull() ?: 0
    printPaper(points, maxX + 1, maxY + 1)
}

fun printPaper(points: Set<Pair<Int, Int>>, maxX: Int, maxY: Int) {
    val paper = Array(maxY) { CharArray(maxX) { '.' } }

    for (point in points) {
        paper[point.second][point.first] = '#'
    }

    for (line in paper) {
        println(line.concatToString())
    }
}

fun main() {
    println(part1(readInput("Day13", "Day13")))
    println(part2(readInput("Day13", "Day13")))
}