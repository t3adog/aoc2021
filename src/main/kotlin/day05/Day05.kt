package day05

import readInput

//this code smell like shit.

class Coordinate(emp_x: Int, emp_y: Int) {
    var x: Int = 0
        get() = field

    var y: Int = 0
        get() = field

    init {
        x = emp_x
        y = emp_y
    }
}

fun generateDiagram(x: Int, y: Int): MutableList<MutableList<Int>> {
    val result: MutableList<MutableList<Int>> = mutableListOf()
    for (verticalIndex: Int in 0..y) {
        val line: MutableList<Int> = mutableListOf()
        for (horizontIndex: Int in 0..x) {
            line.add(0)
        }
        result.add(line)
    }
    return result
}

fun printDiagram(diagram: List<List<Int>>) {
    for (line in diagram) {
        println(line)
    }
}

fun parseCoordinates(input: List<String>): List<Pair<Coordinate, Coordinate>> {
    val result: MutableList<Pair<Coordinate, Coordinate>> = mutableListOf()
    for (line in input) {
        val splitedLine = line.split("->")
        val fromStr = splitedLine[0].trim().split(",")
        val toStr = splitedLine[1].trim().split(",")
        val from = Coordinate(fromStr[0].toInt(), fromStr[1].toInt())
        val to = Coordinate(toStr[0].toInt(), toStr[1].toInt())
        result.add(Pair(from, to))
    }
    return result
}

fun isConsiderLine(from: Coordinate, to: Coordinate): Boolean {
    return (from.x == to.x) || (from.y == to.y)
}

fun drawHorizontalLine(from: Coordinate, to: Coordinate, diagram: MutableList<MutableList<Int>>) {
    if (from.x == to.x) {
        if (from.y < to.y) {
            for (y: Int in from.y..to.y) {
                diagram[from.x][y] += 1
            }
        } else {
            for (y: Int in to.y..from.y) {
                diagram[from.x][y] += 1
            }
        }
    }
    if (from.y == to.y) {
        if (from.x < to.x) {
            for (x: Int in from.x..to.x) {
                diagram[x][from.y] += 1
            }
        } else {
            for (x: Int in to.x..from.x) {
                diagram[x][from.y] += 1
            }
        }
    }
}

fun count(diagram: MutableList<MutableList<Int>>): Int {
    var count = 0
    for (line: List<Int> in diagram) {
        for (cell: Int in line) {
            if (cell >= 2) {
                count += 1
            }
        }
    }
    return count
}

fun findMaxCoordinates(coordinates : List<Pair<Coordinate, Coordinate>>): Int {
    var maxValue = 0;
    for (coordinate in coordinates) {
        if (maxValue < coordinate.first.x) {
            val mac = maxOf(coordinate.first.x, coordinate.first.y, coordinate.second.x, coordinate.second.y)
            if (maxValue < mac) {
                maxValue = mac
            }
        }
    }
    return maxValue + 1;
}

fun part1(input: List<String>): Int {
    val coordinates = parseCoordinates(input)
    val max = findMaxCoordinates(coordinates)
    val diagram = generateDiagram(max, max)
    for (coordinate in coordinates) {
        val from = coordinate.first
        val to = coordinate.second
        if (isConsiderLine(from, to)) {
            drawHorizontalLine(from, to, diagram)
        }
    }
    return count(diagram)
}

fun part2(input: List<String>): Int {
    return 0
}

fun main() {
    val input = readInput("day05", "Day05")
    println(part1(input))
    println(part2(input))
}