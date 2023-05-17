package aoc2022

import utils.loadData

fun main() {

    val fileName = "src/main/resources/aoc2022/day4"
    val assignments = loadData(fileName)

    val result = firstTask(assignments)
    println("First task = $result")
}

fun firstTask(data: List<String>): Int {
    var count = 0
    for (pair in data) {
        val pairs: List<String> = pair.split(",")
        val elfs = mutableListOf<List<Int>>()
        pairs.map { it ->
            val elf = it.split("-").map { it.toInt() }
            elfs.add(elf[0].rangeTo(elf[1]).toList())
        }
        count += if (isSubset(elfs)) 1 else 0
    }
    return count
}

fun isSubset(pairs: MutableList<List<Int>>): Boolean {
    val intersection = pairs[0].intersect(pairs[1].toSet()).toSet()
    return intersection == pairs[1].toSet() || intersection == pairs[0].toSet()
}


