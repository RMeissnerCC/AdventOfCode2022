package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3KtTest {
    @Test
    fun testSplitRucksack() {
        var input = "vJrwpWtwJgWrhcsFMMfFFhFp"
        assertEquals("vJrwpWtwJgWr", firstCompartment(input))
        assertEquals("hcsFMMfFFhFp", secondCompartment(input))

        input = "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL"
        assertEquals("jqHRNqRjqzjGDLGL", firstCompartment(input))
        assertEquals("rsFMfFZSrLrFZsSL", secondCompartment(input))
    }

    @Test
    fun testCompartmentToFirstCommonItem() {
        var first = "vJrwpWtwJgWr"
        var second = "hcsFMMfFFhFp"
        assertEquals("p", compartmentToFirstCommonItem(first, second))
        assertEquals("p", compartmentToFirstCommonItem(second, first))

        first = "jqHRNqRjqzjGDLGL"
        second = "rsFMfFZSrLrFZsSL"
        assertEquals("L", compartmentToFirstCommonItem(first, second))
        assertEquals("L", compartmentToFirstCommonItem(second, first))
    }

    @Test
    fun testConvertItemToPriority() {
        var item = "p"
        assertEquals(16, convertItemToPriority(item))
        item = "L"
        assertEquals(38, convertItemToPriority(item))
        item = "v"
        assertEquals(22, convertItemToPriority(item))
        item = "a"
        assertEquals(1, convertItemToPriority(item))
        item = "Z"
        assertEquals(52, convertItemToPriority(item))
    }
}