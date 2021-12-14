package day14

import readInput

fun parsePairInsertion(input: List<String>): Map<String, String> {
    var pairInsertion = mutableMapOf<String, String>()
    for (line in input) {
        var (key, value) = line.split("->")
        pairInsertion.put(key.trim(), value.trim())
    }
    return pairInsertion
}

fun part1(input: List<String>): Int { // this code smell is mine
    val polymerTemplate = input.get(0).toMutableList()
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
    }

    val allKeys = polymerTemplate.distinct()
    println(allKeys)
    val counts = mutableMapOf<Char, Int>()

    for (key in allKeys) {
        counts.put(key, polymerTemplate.count({ it.equals(key) }))
    }

    return (counts.values.maxOrNull() ?: 0) - (counts.values.minOrNull() ?: 0)
}

fun part2(input: List<String>): Long { // I stole it..
    val polymerTemplate = input.get(0)
    val pairInsertion = parsePairInsertion(input.subList(2, input.size))

    var polymerMap = mutableMapOf<String, Long>()
    for (polymerIndex in polymerTemplate.indices) {
        if (polymerIndex + 1 < polymerTemplate.length) {
            polymerMap.put(polymerTemplate[polymerIndex].toString() + polymerTemplate[polymerIndex + 1].toString(), 1)
        }
    }

    for (step in 0..39) {
        polymerMap = polymerMap.flatMap { (a, c) ->
            val b = pairInsertion[a]!!
            listOf("${a[0]}$b" to c, "$b${a[1]}" to c)
        }
            .groupingBy { it.first }
            .fold(0L) { a, e -> a + e.second }
            .toMutableMap()
    }

    val counts = polymerMap
        .flatMap { (p, c) -> listOf(p[0] to c, p[1] to c) }
        .groupingBy { it.first }
        .fold(0L) { a, e -> a + e.second }
        .toMutableMap()

    counts[polymerTemplate.first()] = counts[polymerTemplate.first()]!! + 1
    counts[polymerTemplate.last()] = counts[polymerTemplate.last()]!! + 1
    val l = counts.map { it.value / 2 }
    val min = l.minOrNull()!!
    val max = l.maxOrNull()!!
    return max - min
}

fun main() {
    println(part1(readInput("Day14", "Day14")))
    println(part2(readInput("Day14", "Day14")))
}