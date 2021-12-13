package day13

import readInput

fun printPaper(paper: List<List<String>>) {
    for (line in paper) {
        println(line)
    }
}

fun generateEmptyPaper(maxY: Int, maxX: Int): MutableList<MutableList<String>> {
    val paper = mutableListOf<MutableList<String>>()

    for (y: Int in 0..maxY) {
        val line = mutableListOf<String>()
        for (x: Int in 0..maxX) {
            line.add(".")
        }
        paper.add(line)
    }
    return paper
}

fun fillPaper(paper: MutableList<MutableList<String>>, points: List<Pair<Int, Int>>) {
    for (point in points) {
        paper[point.second][point.first] = "#"
    }
}

fun foldByY(paper: MutableList<MutableList<String>>, y: Int): MutableList<MutableList<String>> {

    printPaper(paper)
    val part1 = mutableListOf<MutableList<String>>()
    val part2 = mutableListOf<MutableList<String>>()

    for (i in 0..y - 1) {
        part1.add(paper.get(i))
    }

    for (i in y + 1..paper.size - 1) {
        part2.add(paper.get(i))
    }

    println("Part 1")
    printPaper(part1)
    println("Part 2")
    printPaper(part2)

    // реверсируем вторую часть

    part2.reverse()

    println("Reversed part 2")
    printPaper(part2)

    for (lineIndex in part2.indices) {
        for (symbolIndex in part2[lineIndex].indices) {
            if (part2[lineIndex][symbolIndex] == "#") {
                part1[lineIndex][symbolIndex] = "#"
            }
        }
    }

    println("Final cut:")
    printPaper(part1)
    return part1
}

fun foldByX(paper: MutableList<MutableList<String>>, x: Int): MutableList<MutableList<String>> {
    val part1 = mutableListOf<MutableList<String>>()
    val part2 = mutableListOf<MutableList<String>>()

    for (yIndex in 0.. paper.size - 1) {
        val line = mutableListOf<String>()
        for (xIndex in 0..x-1) {
            line.add(paper[yIndex][xIndex])
        }
        part1.add(line)
    }

    for (yIndex in 0.. paper.size - 1) {
        val line = mutableListOf<String>()
        for (xIndex in x+1..paper[yIndex].size-1) {
            line.add(paper[yIndex][xIndex])
        }
        part2.add(line)
    }

    println("Part 1")
    printPaper(part1)
    println("Part 2")
    printPaper(part2)

    // реверсируем
    for (line in part2) {
        line.reverse()
    }

    println("Reversed 2")
    printPaper(part2)

    for (lineIndex in part2.indices) {
        for (symbolIndex in part2[lineIndex].indices) {
            if (part2[lineIndex][symbolIndex] == "#") {
                part1[lineIndex][symbolIndex] = "#"
            }
        }
    }

    return part1
}

fun part1(input: List<String>): Int {
    val points = input
        .filter { !it.contains("fold along") }
        .filter { it.length > 0 }
        .map { Pair(it.split(",")[0].toInt(), it.split(",")[1].toInt()) }

    val maxX = points.map { it.first }.maxOrNull() ?: 0
    val maxY = points.map { it.second }.maxOrNull() ?: 0
    println("max y: $maxY, max x: $maxX")
    val foldInstructions = input.filter { it.contains("fold along") }
    var paper = generateEmptyPaper(maxY, maxX)
    fillPaper(paper, points)
    printPaper(paper)

    println("")
    println("")
    println("")

    for (foldInstruction in listOf<String>(foldInstructions[0])) {
        if (foldInstruction.contains("y")) {
            paper = foldByY(paper, foldInstruction.split("=")[1].toInt())
        } else {
            paper = foldByX(paper, foldInstruction.split("=")[1].toInt())
        }
    }

    println("FINAL FINAL ")
    printPaper(paper)
    return paper.flatten().count {it.equals("#")}
}

fun part2(input: List<String>): Int {
    val points = input
        .filter { !it.contains("fold along") }
        .filter { it.length > 0 }
        .map { Pair(it.split(",")[0].toInt(), it.split(",")[1].toInt()) }

    val maxX = points.map { it.first }.maxOrNull() ?: 0
    val maxY = points.map { it.second }.maxOrNull() ?: 0
    println("max y: $maxY, max x: $maxX")
    val foldInstructions = input.filter { it.contains("fold along") }
    var paper = generateEmptyPaper(maxY, maxX)
    fillPaper(paper, points)
    printPaper(paper)

    println("")
    println("")
    println("")

    for (foldInstruction in foldInstructions) {
        if (foldInstruction.contains("y")) {
            paper = foldByY(paper, foldInstruction.split("=")[1].toInt())
        } else {
            paper = foldByX(paper, foldInstruction.split("=")[1].toInt())
        }
    }

    println("FINAL FINAL ")
    printPaper(paper)
    return paper.flatten().count {it.equals("#")}
}

fun main() {
    println(part1(readInput("Day13", "Day13")))
    println(part2(readInput("Day13", "Day13")))
}