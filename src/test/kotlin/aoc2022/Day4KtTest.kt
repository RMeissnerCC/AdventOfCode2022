package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.loadData

class Day4KtTest {
    @Test
    fun testFirstTask() {
        val data = "2-4,6-8\n" +
                "2-3,4-5\n" +
                "5-7,7-9\n" +
                "2-8,3-7\n" +
                "6-6,4-6\n" +
                "2-6,4-8"
        var assignments = data.split("\n")
        assertEquals(2, firstTask(assignments))


        val fileName = "src/main/resources/aoc2022/day4"
        assignments = loadData(fileName)
        assertEquals(534, firstTask(assignments))

        assertEquals(841, secondTask(assignments))
    }

    @Test
    fun testIsSubset() {
        var elfs = mutableListOf(intArrayOf(0, 1, 2).toList(), intArrayOf(3).toList())
        assertEquals(false, isSubset(elfs))

        elfs = mutableListOf(intArrayOf(0, 1, 2).toList(), intArrayOf(1).toList())
        assertEquals(true, isSubset(elfs))

        elfs = mutableListOf(intArrayOf(0, 1, 2).toList(), intArrayOf(1, 2, 3).toList())
        assertEquals(false, isSubset(elfs))

        elfs = mutableListOf(intArrayOf(0, 1, 2).toList(), intArrayOf(0,1,2).toList())
        assertEquals(true, isSubset(elfs))

    }
    @Test
    fun testHasOverlap() {
        var elfs = mutableListOf(intArrayOf(0, 1, 2).toList(), intArrayOf(3).toList())
        assertEquals(false, hasOverlap(elfs))

        elfs = mutableListOf(intArrayOf(0, 1, 2).toList(), intArrayOf(1).toList())
        assertEquals(true, hasOverlap(elfs))

        elfs = mutableListOf(intArrayOf(0, 1, 2).toList(), intArrayOf(1, 2, 3).toList())
        assertEquals(true, hasOverlap(elfs))

        elfs = mutableListOf(intArrayOf(0, 1, 2).toList(), intArrayOf(0,1,2).toList())
        assertEquals(true, hasOverlap(elfs))

    }
}