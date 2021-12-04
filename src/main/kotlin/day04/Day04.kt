package day04

import readInput

class BingoNumber(emp_value: Int) {
    var value: Int = 0
        get() = field
        set(value) {
            field = value
        }
    var selected: Boolean = false
        get() = field
        set(value) {
            field = value
        }

    init {
        value = emp_value
    }
}


fun generateBingoBoards(input: List<String>): List<List<List<BingoNumber>>> {
    val result: MutableList<List<List<BingoNumber>>> = mutableListOf()
    val bingoBoardsCount = (input.size - 2) / 6
    var offset = 0
    for (step: Int in 0..bingoBoardsCount) {
        val board: MutableList<List<BingoNumber>> = mutableListOf()
        for (row: Int in offset..offset.plus(4)) {
            val line = input[row]
                .replace(" ", " ")
                .split(" ")
                .filter { it -> it.length > 0 }
                .map { BingoNumber(it.replace(" ", "").toInt()) }
            board.add(line)
        }
        result.add(board)
        offset += 6
    }
    return result
}

fun markBoard(board: List<List<BingoNumber>>, number: Int) {
    for (line in board) {
        for (num in line) {
            if (num.value == number) {
                num.selected = true
            }
        }
    }
}

fun printBoard(board: List<List<BingoNumber>>) {
    for (line in board) {
        for (num in line) {
            print(" ${num.value} - ${num.selected} ")
        }
        println(" ")
    }
    println(" ")
}

fun areYouWinningSun(board: List<List<BingoNumber>>): Boolean {
    for (line in board) {
        val countOnLine = line.count { it.selected }
        if (countOnLine == 5) return true
    }
    for (index: Int in 0..4) {
        var countOnRow = 0
        for (line in board) {
            if (line[index].selected) countOnRow += 1
        }
        if (countOnRow == 5) return true
    }
    return false
}

fun calculateUncheckedNumbersSum(board: List<List<BingoNumber>>): Int {
    var finalSum = 0

    for (line in board) {
        val unchekedNumbersSum = line.filter { !it.selected }.map { it.value }.toList().sum()
        finalSum += unchekedNumbersSum
    }

    return finalSum
}

fun part1(input: List<String>): Int {
    val bingoNumbers = input[0].split(",").map { it.toInt() }
    val boards = generateBingoBoards(input.subList(2, input.size))

    var win = false
    var winNumber = 0
    var unchekedNumbersSum = 0

    for (bingoNum in bingoNumbers) {
        for (board in boards) {
            markBoard(board, bingoNum)
            win = areYouWinningSun(board)
            if (win) {
                winNumber = bingoNum
                unchekedNumbersSum = calculateUncheckedNumbersSum(board)
                break
            }
        }
        if (win) {
            break
        }
    }
    return unchekedNumbersSum * winNumber
}

fun part2(input: List<String>): Int {
    return 0
}

fun main() {
    val input = readInput("day04", "Day04")
    println(part1(input)) // 24960 не правильно
    //println(part2(input))
}