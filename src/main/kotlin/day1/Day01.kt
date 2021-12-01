package day1

import readInput

fun part1(input: List<String>): Int {
        var tempNumber = input[0].toInt();
        var count = 0;
        for (itemStr: String in input) {
            val itemInt = itemStr.toInt()
            if (itemInt > tempNumber) {
                count++
            }
            tempNumber = itemInt
        }
        return count
}

fun main() {
    val input = readInput("day1", "Day01")
    println(part1(input))
}