package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.loadData

class Day7KtTest {
    private val fileName = "src/test/resources/day7"
    private val commands = loadData(fileName)
    @Test
    fun testFirstTask() {
        assertEquals(0, day7First(listOf()))
        assertEquals(95437, day7First(commands))
    }
    @Test
    fun testCalculateSizes() {

        val fileSystem = parseFileSystem(commands)
        println(fileSystem)
        assertEquals(48381165, fileSystem.size)
        assertEquals(14848514, fileSystem.getChildren()[0].size)
        assertEquals(94853, fileSystem.getChildren()[2].size)
    }

    @Test
    fun testParseFileSystem() {
        val fileSystem = parseFileSystem(commands)
        assertEquals(48381165, fileSystem.size)
        assertEquals(4, fileSystem.getChildren().size)


    }

    @Test
    fun testGetSmallDirectories() {
        val fileSystem = parseFileSystem(commands)
        assertEquals(2, getSmallDirectories(fileSystem).size)
    }
}
