package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.loadData

class Day5KtTest {
    @Test
    fun testGetTopCrates() {
        val warehouse: Warehouse = mapOf(1 to "CMK", 2 to "MK", 3 to "ZDAA")
        assertEquals("CMZ", warehouse.getTopCrates())
    }

    @Test
    fun testMove() {
        val warehouse: Warehouse = mapOf(1 to "CMK", 2 to "GY", 3 to "ZDAA")
        assertEquals(warehouse, warehouse.move(1, 1, 1)) // identity transformation

        var movedWarehouse: Warehouse = mapOf(1 to "MK", 2 to "CGY", 3 to "ZDAA")
        assertEquals(movedWarehouse, warehouse.move(1, 1, 2))

        movedWarehouse = mapOf(1 to "K", 2 to "MCGY", 3 to "ZDAA")
        assertEquals(movedWarehouse, warehouse.move(2, 1, 2))
        movedWarehouse = mapOf(1 to "", 2 to "GY", 3 to "KMCZDAA")
        assertEquals(movedWarehouse, warehouse.move(3, 1, 3))
    }

    @Test
    fun testParseMoveInstruction() {
        var moveInstructionRaw = listOf("move 3 from 5 to 2")
        assertEquals(
            listOf(Triple(3, 5, 2)),
            parseMoveInstruction(moveInstructionRaw)
        )

        moveInstructionRaw = listOf("move 3 from 5 to 2", "move 12 from 1 to 9", "no regex match")
        assertEquals(
            listOf(Triple(3, 5, 2), Triple(12, 1, 9)),
            parseMoveInstruction(moveInstructionRaw)
        )

    }

    @Test
    fun testParseWarehouseSetup() {
        val moveInstructionRaw = listOf("        [F] [Q]         [Q]","[G] [Z] [C] [H] [C] [R] [H] [P] [D]")
        val warehouse =
            mapOf(1 to "G", 2 to "Z", 3 to "FC", 4 to "QH", 5 to "C", 6 to "R", 7 to "QH", 8 to "P", 9 to "D")
        assertEquals(
            warehouse,
            parseWarehouseSetup(moveInstructionRaw)
        )

        // Complete data set
        val fileName = "src/main/resources/aoc2022/day5"
        val assignments = loadData(fileName)
        val rawWarehouse = parseWarehouseSetup(assignments)
        assert(rawWarehouse[1]!!.length == 7)
        assert(rawWarehouse[8]!!.length == 3)

        var allCrates = ""
        for (column in rawWarehouse)
        {
            allCrates += column.value
        }
        assertEquals(56, allCrates.length)

    }

    @Test
    fun testFirstTask() {
        val resultIsNot = "SFPBQDGZV"
        val resultIs = "WCZTHTMPS"

        val fileName = "src/main/resources/aoc2022/day5"
        val assignments = loadData(fileName)
        assertNotEquals(
            resultIsNot,
            day5Task1(assignments)
        )

        assertEquals(
            resultIs,
            day5Task1(assignments))

    }


}