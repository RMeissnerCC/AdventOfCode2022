package aoc2022

import utils.loadData

// Can I use difference mapping, i.e, create four matrices with differences to the next neighbour?
// how do I brute force this
//  how would it scale?

typealias TreeRow = List<Int>
typealias Forest = List<TreeRow>

fun main() {
    val fileName = "src/main/resources/aoc2022/day8"
    val textTrees = loadData(fileName)
    val trees = parseTrees(textTrees)
    day8First(trees).also { println(it) }
}

fun parseTrees(textTrees: List<String>): Forest {
    return textTrees.map { it -> it.toCharArray().map { it.toString().toInt() } }
}

fun day8First(input: Forest): Int {
    val forest = visibleFromLeft(input) + visibleFromRight(input)
    return forest.sumOf { it -> it.sumOf { it } }
}

fun visibleFromLeft(input: Forest): Forest {
    return input.map { highestTree(it) }
}

fun visibleFromRight(input: Forest): Forest {
    return visibleFromLeft(input.map { it.reversed() })
}

fun highestTree(trees: TreeRow): TreeRow {
    var highestTree = trees.first()
    var index = 0
    val visibleTrees = IntArray(trees.size) { 0 }.toMutableList()
    visibleTrees[0] = 1

    do {
        val newIndex = trees.slice(index + 1 until trees.size).indexOfFirst { it > highestTree }
        if (newIndex != -1) {
            index += newIndex + 1
            highestTree = trees[index]
            visibleTrees[index] = 1
        }
    } while (newIndex != -1)

    return visibleTrees

}
