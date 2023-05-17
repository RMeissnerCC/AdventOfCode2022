package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day5KtTest {
    @Test
    fun testGetTopCrates() {
        val warehouse: Warehouse = mapOf(1 to "CMK", 2 to "MK", 3 to "ZDAA")
        assertEquals("CMZ", warehouse.getTopCrates())
    }
    @Test
    fun testMove() {
        val warehouse: Warehouse = mapOf(1 to "CMK", 2 to "GY", 3 to "ZDAA")
        assertEquals(warehouse, warehouse.move(1,1,1)) // identity transformation

        val movedWarehouse: Warehouse = mapOf(1 to "MK", 2 to "CGY", 3 to "ZDAA")
        assertEquals(movedWarehouse, warehouse.move(1,1,2)) // identity transformation
    }


}