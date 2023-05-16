package `2020`

import java.io.File

val target = 2020
fun main() {
    val fileName = "src/main/resources/2020/day1"
    var lines: List<Int> = File(fileName).bufferedReader().readLines().map (String::toInt)
    matchTwoLines(lines)
    matchThreeLines(lines)
    matchWithComplements(lines)
    val triple = lines.findTripleOfSum()
    println(triple?.let { (x, y, z) -> x * y * z} )

}
fun List<Int>.findTripleOfSum(): Triple<Int, Int, Int>? =
    firstNotNullOfOrNull { x ->
        findPairOfSum(2020 - x)?.let { pair ->
            Triple(x, pair.first, pair.second)
        }
    }

fun List<Int>.findPairOfSum(sum: Int): Pair<Int, Int>? {
    // Map: sum - x -> x
    val complements = associateBy { sum - it }
    return firstNotNullOfOrNull { number ->
        val complement = complements[number]
        if (complement != null) Pair(number, complement) else null
    }
}
fun matchWithComplements(numbers: List<Int>) {
    val complements = numbers.associateBy { 2020 - it }

    val pair = numbers.firstNotNullOfOrNull { number ->
        val complement = complements[number]
        if (complement != null) Pair(number, complement) else null
    }
    println(pair?.let { (a, b) -> a * b })
}

private fun matchTwoLines(lines: List<Int>) {
    for (line in lines) {
        for (secondLine in lines) {
            if (secondLine + line == target) {
                println("${secondLine * line}: $line, $secondLine")
                break
            }
        }
    }
}

private fun matchThreeLines(lines: List<Int>) {
    for (line in lines) {
        for (secondLine in lines) {
            for (third in lines) {
                if (secondLine + line + third == target) {
                    println("${secondLine * line * third}: $line, $secondLine, $third")
                    break
                }
            }
        }
    }
}