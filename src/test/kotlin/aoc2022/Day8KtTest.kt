package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.loadData

class Day8KtTest {
    private val testTrees = parseTrees(loadData("src/test/resources/day8"))
    private val realTrees = parseTrees(loadData("src/main/resources/aoc2022/day8"))

    @Test
    fun testFirstTask() {
        assertEquals(0, day8First(listOf()))
        assertEquals(21, day8First(testTrees))
        assertNotEquals(2023, day8First(realTrees))

    }

    private fun countVisibleTrees(trees: Forest, countFun: (Forest, Int, Int) -> Boolean): Int {
        return List(trees[0].size) { column -> countFun(trees, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
    }

    @Test
    fun testVisibleFromLeft() {
        var treeRow = parseTrees(listOf("30373"))

        assertEquals(2, countVisibleTrees(treeRow, ::isLeftMax))

        treeRow = parseTrees(listOf("65332"))
        assertEquals(1, countVisibleTrees(treeRow, ::isLeftMax))

        treeRow = parseTrees(listOf("33549"))
        assertEquals(3, countVisibleTrees(treeRow, ::isLeftMax))

        treeRow =
            parseTrees(listOf("012112312021432444002222553400425232521024405364230243502011133453405140031345502304422434041110301"))
        assertEquals(7, countVisibleTrees(treeRow, ::isLeftMax))
    }

    @Test
    fun testVisibleFromRight() {
        var treeRow = parseTrees(listOf("30373"))
        assertEquals(2, countVisibleTrees(treeRow, ::isRightMax))

        treeRow = parseTrees(listOf("65332"))
        assertEquals(4, countVisibleTrees(treeRow, ::isRightMax))

        treeRow = parseTrees(listOf("33549"))
        assertEquals(1, countVisibleTrees(treeRow, ::isRightMax))

        treeRow = parseTrees(listOf("54321"))
        assertEquals(5, countVisibleTrees(treeRow, ::isRightMax))

        treeRow =
            parseTrees(listOf("012112312021432444002222553400425232521024405364230243502011133453405140031345502304422434041110301"))
        assertEquals(5, countVisibleTrees(treeRow, ::isRightMax))
    }

    @Test
    fun test2D() {

        val forest = parseTrees(listOf("345", "123", "234"))

        val transposedForest = transposeMatrix(forest)
        var visibleTree = transposedVisibleTree(transposedForest, ::isLeftMax)
        println(visibleTree)
        assertEquals(3, visibleTree.size)
        assertEquals(3, visibleTree[0].size)
        assertEquals(3, visibleTree.sumOf { outer -> outer.sumOf { if (it) 1.0 else 0.0 }.toInt() })


        visibleTree = transposedVisibleTree(transposedForest, ::isRightMax)
        println(visibleTree)
        assertEquals(3, visibleTree.size)
        assertEquals(3, visibleTree[0].size)
        assertEquals(true, visibleTree[0][0])
        assertEquals(6, visibleTree.sumOf { outer -> outer.sumOf { if (it) 1.0 else 0.0 }.toInt() })
    }

    private fun transposedVisibleTree(
        forest: Forest,
        countFun: (Forest, Int, Int) -> Boolean
    ): MutableList<MutableList<Boolean>> {
        val visibleTree = Array(forest.size) { Array(forest.size) { false }.toMutableList() }.toMutableList()

        forest.forEachIndexed { row, ints ->
            for (column in ints.indices) {
                // Inverted indices here
                visibleTree[row][column] = countFun(forest, row, column)
                println("Tree value ${forest[row][column]} -> ${visibleTree[row][column]}")
            }
        }
        return visibleTree
    }
}
