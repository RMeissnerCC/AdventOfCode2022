package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.loadData

class Day7KtTest {
    @Test
    fun testFirstTask() {
        assertEquals(0, day7First(listOf()))
    }

    @Test
    fun testParseFileSystem() {
        val fileName = "src/test/resources/day7"
        val commands = loadData(fileName)
        val fileSystem = parseFileSystem(commands)
        assertEquals(0, fileSystem.size)
        println(fileSystem.getChildren())
        assertEquals(1, fileSystem.getChildren().size)


    }

    @Test
    fun testGetSmallDirectories() {
        val hot = TreeNode("Hot")
        val cold = TreeNode("Cold")

        val root = TreeNode("Beverages")
        root.add(hot)
        root.add(cold)
        assertEquals(0, getSmallDirectories(root).size)
    }
}