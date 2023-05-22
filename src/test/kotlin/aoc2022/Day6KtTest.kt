package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.loadData

class Day6KtTest {
    @Test
    fun testFirstTask() {
        val fileName = "src/main/resources/aoc2022/day6"
        val signals = loadData(fileName).first()
        val output = firstTask(signals)
        assertNotEquals(1905, output)
    }

    @Test
    fun testTestInput() {
        val signals = "bvwbjplbgvbhsrlpgdmjqwftvncz"
        val output = firstTask(signals)
        assertEquals(5, output)
    }

    @Test
    fun testsecondInput() {
        val signals = "mjqjpqmgbljsphdztnvjfqwrcgsmlb"
        val output = secondTask(signals)
        assertEquals(19, output)
    }
}