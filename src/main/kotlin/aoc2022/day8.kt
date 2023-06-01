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

fun day8First(forest: Forest): Int {
    val visibleTree = buildVisibleTrees(forest)
    return visibleTree.flatten().sumOf { if (it) 1.0 else 0.0 }.toInt()
}


fun transposeMatrix(matrix: Forest): Forest {
    // source: https://stackoverflow.com/questions/26197466/transposing-a-matrix-from-a-2d-array
    val m = matrix.size
    if (m == 0) return matrix

    val n = matrix[0].size
    val transposedMatrix = Array(n) { IntArray(m).toMutableList() }.toMutableList()
    for (x in 0 until n) {
        for (y in 0 until m) {
            transposedMatrix[x][y] = matrix[y][x]
        }
    }
    println(matrix)
    println(transposedMatrix)
    return transposedMatrix
}

private fun buildVisibleTrees(forest: Forest): MutableList<MutableList<Boolean>> {
    val transposedForest = transposeMatrix(forest)
    val visibleTree = Array(forest.size) { Array(forest.size) { false }.toMutableList() }.toMutableList()
    forest.forEachIndexed { row, ints ->
        for (column in ints.indices) {

            var treeVisible = isLeftMax(forest, row, column)
            if (!treeVisible) {
                treeVisible = isRightMax(forest, row, column)
            }
            if (!treeVisible) {
                treeVisible = isLeftMax(transposedForest, column, row)
            }
            if (!treeVisible) {
                treeVisible = isRightMax(transposedForest, column, row)
            }
            visibleTree[row][column] = treeVisible
        }
    }
    println("Is max? $visibleTree")
    return visibleTree
}

fun isRightMax(forest: Forest, row: Int, column: Int): Boolean {
    return isLeftMax(forest.map { it.reversed() }, row, (forest[row].size - 1) - column)

}

fun isLeftMax(forest: Forest, row: Int, column: Int): Boolean {
    return column == 0 || forest[row].slice(0 until column).max() < forest[row][column]

}

