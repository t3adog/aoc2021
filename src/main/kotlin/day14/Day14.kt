package day14

import readInput

fun parsePairInsertion(input: List<String>): Map<String, String> {
    var pairInsertion = mutableMapOf<String, String>()
    for (line in input) {
        println(line)
        var (key, value) = line.split("->")
        pairInsertion.put(key.trim(), value.trim())
    }
    return pairInsertion
}

fun part1(input: List<String>): Int {
    var polymerTemplate = input.get(0).toMutableList()
    val pairInsertion = parsePairInsertion(input.subList(2, input.size))
    println(polymerTemplate)
    println(pairInsertion)

    val newPolymerTemplate = mutableListOf<Char>()
    for (step in 0..9) {
        for (index in polymerTemplate.indices) {
            if (index + 1 < polymerTemplate.size) {
                val key = polymerTemplate[index].toString() + polymerTemplate[index + 1].toString()
                val value = pairInsertion.getValue(key)
                newPolymerTemplate.add(key.toCharArray()[0])
                newPolymerTemplate.add(value[0])
            }
        }
        newPolymerTemplate.add(polymerTemplate.last())
        polymerTemplate.clear()
        polymerTemplate.addAll(newPolymerTemplate)
        newPolymerTemplate.clear()
        println("Step: ${step + 1}, polymer: ${polymerTemplate.joinToString("")}")
    }

    val allKeys = polymerTemplate.distinct()
    println(allKeys)
    val counts = mutableMapOf<Char, Int>()

    for (key in allKeys) {
        counts.put(key, polymerTemplate.count({it.equals(key)}))
    }

    return (counts.values.maxOrNull() ?: 0) - (counts.values.minOrNull() ?: 0)
}

fun part2(input: List<String>): Int {
    return 0
}

fun main() {
    println(part1(readInput("Day14", "Day14")))
    println(part2(readInput("Day14", "Day14")))
}