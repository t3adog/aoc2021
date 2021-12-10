package day10

import readInput

val symbolMap = mapOf(
    "(" to ")",
    "{" to "}",
    "[" to "]",
    "<" to ">"
)

val corruptedSymbolsScoreTable = mapOf(
    ")" to 3,
    "]" to 57,
    "}" to 1197,
    ">" to 25137
)

val incompleteSymbolsScoreTable = mapOf(
    ")" to 1L,
    "]" to 2L,
    "}" to 3L,
    ">" to 4L
)

fun isLineCorrupted(line: String): Boolean {
    val openedChars = mutableListOf<String>()
    for (char in line.toCharArray().map { it.toString() }) {
        if (char in symbolMap.keys) {
            openedChars.add(char)
        } else {
            if (symbolMap.get(openedChars.last()) == char) {
                openedChars.removeLast()
            } else {
                return true
            }
        }
    }
    return false
}

fun part1(input: List<String>): Int {
    var score = 0
    for (line in input.filter { isLineCorrupted(it) }) {
        val openedChars = mutableListOf<String>()
        for (char in line.toCharArray().map { it.toString() }) {
            if (char in symbolMap.keys) {
                openedChars.add(char)
            } else {
                if (symbolMap.get(openedChars.last()) == char) {
                    openedChars.removeLast()
                } else {
                    score += corruptedSymbolsScoreTable[char] ?: 0
                    break
                }
            }
        }
    }
    return score
}

fun part2(input: List<String>): Long {

    val scores = mutableListOf<Long>()
    for (line in input.filter { !isLineCorrupted(it) }) {
        val openedChars = mutableListOf<String>()
        for (char in line.toCharArray().map { it.toString() }) {
            if (char in symbolMap.keys) {
                openedChars.add(char)
            } else {
                if (symbolMap.get(openedChars.last()) == char) {
                    openedChars.removeLast()
                }
            }
        }
        val charsForClose = mutableListOf<String>()
        for (opennedChar in openedChars.reversed()) {
            charsForClose.add(symbolMap.get(opennedChar) ?: "")
        }
        val score = calculateScoreForIncompleteSymbols(charsForClose)
        scores.add(score)
    }

    return scores.sorted()[scores.size / 2]
}

fun calculateScoreForIncompleteSymbols(closingChars: List<String>): Long {
    var score = 0L

    for (closingChar in closingChars) {
        score = ((score * 5L) + incompleteSymbolsScoreTable[closingChar]!!) ?: 0L
    }
    return score
}

fun main() {
    val input = readInput("day10", "Day10")
    println(part1(input))
    println(part2(input))
}