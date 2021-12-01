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

fun part2(input: List<String>): Int {
    var count = 0;
    var tempNumber = 0;
    for (i in input.indices) {
        if ((i + 2) < input.size) {
            val sum = input[i].toInt() + input[i+1].toInt() + input[i+2].toInt()
            if (sum > tempNumber && i != 0) {
                count++
            }
            tempNumber = sum
        }
    }
    return count

}

fun main() {
    val input = readInput("day1", "Day01")
    println(part1(input))
    println(part2(input))
}