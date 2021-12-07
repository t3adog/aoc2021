import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(day: String, name: String) = File("src/main/kotlin/$day/resource", "$name.txt").readLines()

/**
 * Read lines from file to List<Int>
 */
fun readInputToIntList(day: String, name: String): List<Int> {
    return readInput(day, name)[0].split(",").map { it.toInt() }
}

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)
