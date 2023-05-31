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
        assertEquals(2, visibleFromLeft(treeRow).sumOf { it -> it.sumOf { it } })

        val isMax =
            List(treeRow[0].size) { column -> isLeftMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(2, isMax)

        treeRow = parseTrees(listOf("65332"))
        assertEquals(1, visibleFromLeft(treeRow).sumOf { it -> it.sumOf { it } })

        treeRow = parseTrees(listOf("33549"))
        assertEquals(3, visibleFromLeft(treeRow).sumOf { it -> it.sumOf { it } })
    }

    @Test
    fun testVisibleFromRight() {
        var treeRow = parseTrees(listOf("30373"))
        assertEquals(2, visibleFromRight(treeRow).sumOf { it -> it.sumOf { it } })
        val isMax =
            List(treeRow[0].size) { column -> isRightMax(treeRow, 0, column) }.sumOf { if (it) 1.0 else 0.0 }.toInt()
        assertEquals(2, isMax)

        treeRow = parseTrees(listOf("65332"))
        assertEquals(4, visibleFromRight(treeRow).sumOf { it -> it.sumOf { it } })

        treeRow = parseTrees(listOf("33549"))
        assertEquals(1, visibleFromRight(treeRow).sumOf { it -> it.sumOf { it } })
    }
}