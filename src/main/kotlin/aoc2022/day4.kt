package aoc2022

import utils.loadData

fun main() {

    val fileName = "src/main/resources/aoc2022/day4"
    val assignments = loadData(fileName)

    var result = firstTask(assignments)
    println("First task = $result")

    result = secondTask(assignments)
    println("Second task = $result")
}

fun firstTask(data: List<String>): Int {
    return task(data, ::isSubset)
}

fun task(data: List<String>, matchFun: (MutableList<List<Int>>) -> Boolean): Int {
    var count = 0
    for (pair in data) {
        val elfs = convertPairToElfs(pair)
        count += if (matchFun(elfs)) 1 else 0
    }
    return count
}


fun secondTask(data: List<String>): Int {
    return task(data, ::hasOverlap)
}

private fun convertPairToElfs(pair: String): MutableList<List<Int>> {
    val pairs: List<String> = pair.split(",")
    val elfs = mutableListOf<List<Int>>()
    pairs.map { it ->
        val elf = it.split("-").map { it.toInt() }
        elfs.add(elf[0].rangeTo(elf[1]).toList())
    }
    return elfs
}

// from todd: https://todd.ginsberg.com/post/advent-of-code/2022/day4/


private fun String.asIntRange(): IntRange =
    substringBefore("-").toInt() .. substringAfter("-").toInt()

private fun String.asRanges(): Pair<IntRange,IntRange> =
    substringBefore(",").asIntRange() to substringAfter(",").asIntRange()

fun isSubset(pairs: MutableList<List<Int>>): Boolean {
    val intersection = pairs[0].intersect(pairs[1].toSet()).toSet()
    return intersection == pairs[1].toSet() || intersection == pairs[0].toSet()
}


fun hasOverlap(pairs: MutableList<List<Int>>): Boolean {
    return pairs.first().intersect(pairs.last().toSet()).isNotEmpty()
}


