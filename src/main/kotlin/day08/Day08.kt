package day08

import readInput

fun parseLine(line: String): Pair<String, String> {
    return Pair(line.split("|")[0], line.split("|")[1])
}

fun parseAndSortByChar(templatesStr: String): List<String> {
    val strings = templatesStr.trim().split(" ")
    val sortedStrings = mutableListOf<String>()
    for (template in strings) {
        sortedStrings.add(sortString(template))
    }
    return sortedStrings
}

fun sortString(string: String): String {
    return string.trim().toCharArray().sorted().joinToString("")
}

fun parseSimpleDigitsMap(templates: List<String>): Map<String, Int> {
    val simpleDigitsMap = mutableMapOf<String, Int>()
    simpleDigitsMap[templates.first { it.length == 2 }] = 1
    simpleDigitsMap[templates.first { it.length == 4 }] = 4
    simpleDigitsMap[templates.first { it.length == 3 }] = 7
    simpleDigitsMap[templates.first { it.length == 7 }] = 8
    return simpleDigitsMap
}

fun parseAllDigitsMap(templates: List<String>): Map<String, Int> {
    val allDigitsMap = mutableMapOf<String, Int>()

    // 2, 4, 3, 7
    val simpleDigits = parseSimpleDigitsMap(templates)
    allDigitsMap.putAll(simpleDigits)

    val reversedSimpleDigitsMap = simpleDigits.entries.associate { (key, value) -> value to key }
    val seven = reversedSimpleDigitsMap.getOrDefault(7, "")
    val four = reversedSimpleDigitsMap.getOrDefault(4, "")

    // 2, 3, 5
    val twoThreeFive = templates.filter { it.length == 5 }
    val three = twoThreeFive.first { (it.toList() - seven.toList()).size == 2 }
    val five = (twoThreeFive - three).first({ (it.toList() - four.toList()).size == 2 })
    val two = (twoThreeFive - three - five).joinToString("")

    allDigitsMap[two] = 2
    allDigitsMap[three] = 3
    allDigitsMap[five] = 5

    // 0, 6, 9
    val zeroSixNine = templates.filter { it.length == 6 }
    val nine = zeroSixNine.first { (it.toList() - three.toList()).size == 1 }
    val six = zeroSixNine.first { (it.toList() - seven.toList()).size == 4 }
    val zero = (zeroSixNine - nine - six).joinToString("")

    allDigitsMap[zero] = 0
    allDigitsMap[six] = 6
    allDigitsMap[nine] = 9

    return allDigitsMap
}

fun part1(input: List<String>): Int {
    var instanceCount = 0
    for (line: String in input) {
        val parsedLine = parseLine(line)
        val simpleDigitsMap = parseSimpleDigitsMap(parseAndSortByChar(parsedLine.first))
        val digits = parseAndSortByChar(parsedLine.second)
        for (digit in digits) {
            if (simpleDigitsMap.contains(digit)) {
                instanceCount += 1
            }
        }
    }
    return instanceCount
}

fun part2(input: List<String>): Int { // made with google ☹️
    var result = 0
    for (line: String in input) {
        val parsedLine = parseLine(line)
        val allDigitsMap = parseAllDigitsMap(parseAndSortByChar(parsedLine.first))
        val digits = parseAndSortByChar(parsedLine.second)
        var decodedDigitString = ""
        for (digit in digits) {
            decodedDigitString += allDigitsMap.get(digit)
        }
        result += decodedDigitString.toInt()
    }
    return result
}

fun main() {
    val input = readInput("day08", "Day08")
    println(part1(input))
    println(part2(input))
}