package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.loadData

class Day8KtTest {
    private val trees = loadData("src/test/resources/day8")

    @Test
    fun testFirstTask() {
        assertEquals(0, day8First(listOf()))
        assertEquals(21, day8First(trees))

    }

    @Test
    fun testVisibleFromLeft() {
        var treeRow = "30373"
        assertEquals(2, visibleFromLeft(listOf(treeRow)))

        treeRow = "65332"
        assertEquals(1, visibleFromLeft(listOf(treeRow)))
        treeRow = "33549"
        assertEquals(3, visibleFromLeft(listOf(treeRow)))
    }
    @Test
    fun testVisibleFromRight() {
        var treeRow = "30373"
        assertEquals(2, visibleFromRight(listOf(treeRow)))

        treeRow = "65332"
        assertEquals(4, visibleFromRight(listOf(treeRow)))
        treeRow = "33549"
        assertEquals(1, visibleFromRight(listOf(treeRow)))
    }
}