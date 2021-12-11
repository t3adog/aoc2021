import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(day: String, name: String) = File("src/main/kotlin/$day/resource", "$name.txt").readLines()

fun readInputToMutableList(day: String, name: String) = File("src/main/kotlin/$day/resource", "$name.txt").readLines().toMutableList()

/**
 * Read lines from file to List<Int>
 */
fun readInputToIntList(day: String, name: String): List<Int> {
    return readInput(day, name)[0].split(",").map { it.toInt() }
}

fun readMatrix(day: String, name: String): List<List<Int>> {
    return readInput(day, name).map { it.toList().map { it.digitToInt() } }.toList()
}

fun readMutableMatrix(day: String, name: String): MutableList<MutableList<Int>> {
    return readInputToMutableList(day, name).map { it.toMutableList().map { it.digitToInt() }.toMutableList() }.toMutableList()
}

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
