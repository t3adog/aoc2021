package day03

import readInput

fun convertBinaryToDecimal(num: Long): Int {
    var num = num
    var decimalNumber = 0
    var i = 0
    var remainder: Long

    while (num.toInt() != 0) {
        remainder = num % 10
        num /= 10
        decimalNumber += (remainder * Math.pow(2.0, i.toDouble())).toInt()
        ++i
    }
    return decimalNumber
}

fun part1(input: List<String>): Int {
    var gammaRateStr = ""
    var epsilonRateStr = ""
    val numbers_length = input[0].length

    for (index: Int in 0.rangeTo(numbers_length - 1)) {
        var falseCount = 0
        var trueCount = 0
        for (row: String in input) {
            val char = row.get(index).toString()
            if (char == "0") {
                falseCount++
            } else {
                trueCount++
            }
        }
        if (falseCount > trueCount) {
            gammaRateStr = gammaRateStr + "0"
            epsilonRateStr = epsilonRateStr + "1"
        } else {
            gammaRateStr = gammaRateStr + "1"
            epsilonRateStr = epsilonRateStr + "0"
        }
    }
    val gammaRate = convertBinaryToDecimal(gammaRateStr.toLong())
    val epsilonRate = convertBinaryToDecimal(epsilonRateStr.toLong())
    return gammaRate * epsilonRate
}

fun part2(input: List<String>): Int {
    return 0
}

fun main() {
    val input = readInput("day03", "Day03")
    println(part1(input))
    println(part2(input))
}