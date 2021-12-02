package day02

import readInput

fun part1(input: List<String>): Int {
    var horizontalPosition = 0
    var depth = 0

    for (step : String in input) {
        val stepArr = step.split(" ")
        val action = stepArr[0]
        val value = stepArr[1].toInt()

        when(action){
            "forward" -> horizontalPosition += value
            "down" -> depth += value
            "up" -> depth -= value
        }
    }

    return depth * horizontalPosition
}

fun part2(input: List<String>): Int {
   return 0
}

fun main() {
    val input = readInput("day02", "Day02")
    println(part1(input))
    println(part2(input))
}