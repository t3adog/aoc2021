package day03

import readInput

// work with strings, not bit math because I don't care

fun part1(input: List<String>): Int {
    var gammaRateStr = ""
    var epsilonRateStr = ""
    val numbers_length = input[0].length

    for (index: Int in 0 until numbers_length) {
        var falseCount = 0
        var trueCount = 0
        for (row: String in input) {
            val char = row[index].toString()
            if (char == "0") {
                falseCount++
            } else {
                trueCount++
            }
        }
        if (falseCount > trueCount) {
            gammaRateStr += "0"
            epsilonRateStr += "1"
        } else {
            gammaRateStr += "1"
            epsilonRateStr += "0"
        }
    }
    val gammaRate = gammaRateStr.toInt(2)
    val epsilonRate = epsilonRateStr.toInt(2)
    return gammaRate * epsilonRate
}

enum class rating {
    oxygen,
    co2
}

fun part2(input: List<String>): Int {

    fun getCriteria(trueCount: Int, falseCount: Int, rating: rating): String {
        var bitCriteria = ""
        when (rating) {
            day03.rating.oxygen -> {
                if (falseCount > trueCount) {
                    bitCriteria = "0"
                } else {
                    bitCriteria = "1"
                }
            }
            day03.rating.co2 -> {
                if (falseCount <= trueCount) {
                    bitCriteria = "0"
                } else {
                    bitCriteria = "1"
                }
            }
        }
        return bitCriteria
    }

    fun findRating(input: List<String>, bitPosition: Int, rating: rating): Int {
        var falseCount = 0
        var trueCount = 0
        for (row: String in input) {
            if (row[bitPosition].digitToInt() == 0) {
                falseCount++
            } else {
                trueCount++
            }
        }
        val bitCriteria = getCriteria(trueCount, falseCount, rating)
        val filteredInput = input.filter { it[bitPosition].toString().equals(bitCriteria) }
        if (filteredInput.size == 1) {
            return filteredInput[0].toInt(2)
        } else {
            return findRating(filteredInput, bitPosition.plus(1), rating)
        }
    }

    return findRating(input, 0, rating.oxygen) * findRating(input, 0, rating.co2)
}

fun main() {
    val input = readInput("day03", "Day03")
    println(part1(input))
    println(part2(input))
}