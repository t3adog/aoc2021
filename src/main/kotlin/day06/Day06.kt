package day06

import readInput

// It is flyweight pattern concept
fun initLanternFishesMap(lanternFishes: MutableList<Int>): MutableMap<Int, Long> {
    val flyweightMap = mutableMapOf<Int, Long>()

    for (lanterFish in lanternFishes) {
        var lanterFishCount = flyweightMap.getOrPut(lanterFish, { 0 })
        lanterFishCount += 1
        flyweightMap.put(lanterFish, lanterFishCount)
    }
    return flyweightMap
}

fun simulateAndCount(lanternFishes: MutableList<Int>, simulateDays: Int): Long {
    val initialMap = initLanternFishesMap(lanternFishes)
    for (day in 1..simulateDays) {

        val copyMap = HashMap(initialMap)

        for (day: Int in 8 downTo 0) {
            if (day == 0) {
                initialMap[6] = copyMap.getOrPut(7) { 0 } + copyMap.getOrPut(day) { 0 }
                initialMap[8] = copyMap.getOrPut(day) { 0 }
            } else {
                initialMap[day - 1] = copyMap.getOrPut(day) { 0 }
            }
        }
    }

    return initialMap.values.sum()
}

fun part1(input: String): Long {
    val lanternFishes = input.split(",").map { it.toInt() }.toMutableList()
    return simulateAndCount(lanternFishes, 80)
}

fun part2(input: String): Long {
    val lanternFishes = input.split(",").map { it.toInt() }.toMutableList()
    return simulateAndCount(lanternFishes, 256)
}

fun main() {
    val input = readInput("day06", "Day06")
    println(part1(input[0]))
    println(part2(input[0]))
}