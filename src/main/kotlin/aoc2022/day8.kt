package aoc2022

import utils.loadData

// Can I use difference mapping, i.e, create four matrices with differences to the next neighbour?
// how do I brute force this
//  how would it scale?

typealias Trees = List<List<Int>>

fun main() {
    val fileName = "src/main/resources/aoc2022/day8"
    val trees = loadData(fileName)
    day8First(trees).also { println(it) }
}

fun day8First(input: List<String>): Int {
    return visibleFromLeft(input) + visibleFromRight(input)
}

fun visibleFromLeft(input: List<String>): Int {
    return input.sumOf { highestTree(it.toCharArray().map { it.toString().toInt() }) }
}

fun visibleFromRight(input: List<String>): Int {
    return visibleFromLeft(input.map { it.reversed() })
}

fun highestTree(trees: List<Int>): Int {
    var visible = 1
    var highestTree = trees.first()
    var index = 0

    do {
        val newIndex = trees.slice(index + 1 until trees.size).indexOfFirst { it > highestTree }
        if (newIndex != -1) {
            index += newIndex + 1
            highestTree = trees[index]
            visible += 1
        }
    } while (newIndex != -1)

    return visible

}
