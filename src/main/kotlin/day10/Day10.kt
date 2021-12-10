package day10

import readInput

val symbol_map = mapOf<String, String>(
    "(" to ")",
    "{" to "}",
    "[" to "]",
    "<" to ">"
)

val score_table = mapOf(
    ")" to 3,
    "]" to 57,
    "}" to 1197,
    ">" to 25137
)

fun part1(input: List<String>): Int {
    var score = 0
    for (line in input) {
        val openedChars = mutableListOf<String>()
        for (char in line.toCharArray().map { it.toString() }) {
            if (char in symbol_map.keys) {
                openedChars.add(char)
            } else {
                if (symbol_map.get(openedChars.last()) == char) {
                    openedChars.removeLast()
                } else {
                    score += score_table[char] ?: 0
                    break
                }
            }
        }
    }
    return score
}

fun part2(input: List<String>): Int {
    return 0
}

fun main() {
    val input = readInput("day10", "Day10")
    println(part1(input))
    println(part2(input))
}