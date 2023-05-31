package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.loadData

class Day8KtTest {
    private val trees = parseTrees(loadData("src/test/resources/day8"))

    @Test
    fun testFirstTask() {
        assertEquals(0, day8First(listOf()))
        assertEquals(21, day8First(trees))

    }

    @Test
    fun testVisibleFromLeft() {
        var treeRow = parseTrees(listOf("30373"))

        var isMax =
            List(treeRow[0].size) { column -> isLeftMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(2, isMax)

        treeRow = parseTrees(listOf("65332"))
        isMax =
            List(treeRow[0].size) { column -> isLeftMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(1, isMax)

        treeRow = parseTrees(listOf("33549"))
        isMax =
            List(treeRow[0].size) { column -> isLeftMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(3, isMax)
    }

    @Test
    fun testVisibleFromRight() {
        var treeRow = parseTrees(listOf("30373"))
        var isMax =
            List(treeRow[0].size) { column -> isRightMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(2, isMax)

        treeRow = parseTrees(listOf("65332"))
        isMax =
            List(treeRow[0].size) { column -> isRightMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(4, isMax)

        treeRow = parseTrees(listOf("33549"))
        isMax =
            List(treeRow[0].size) { column -> isRightMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(1, isMax)

        treeRow = parseTrees(listOf("54321"))
        isMax =
            List(treeRow[0].size) { column -> isRightMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(5, isMax)
    }
}