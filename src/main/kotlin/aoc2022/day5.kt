package aoc2022

import utils.loadData

typealias Crate = String
typealias Warehouse = Map<Int, Crate>
typealias MoveInstruction = MutableList<Triple<Int, Int, Int>>

val moveRegex = "move\\s(\\d+)\\sfrom\\s(\\d)\\sto\\s(\\d)".toRegex()
val warehouseRegex = "[\\[\\s?]([\\w\\s?])[]\\s?]\\s?".toRegex()
fun main() {

    val fileName = "src/main/resources/aoc2022/day5"
    val assignments = loadData(fileName)
    val output = day5Task1(assignments)
    println("Final order of crates: $output")
}

fun day5Task1(assignments: List<String>): String {
    // parse crate setup
    var warehouse = parseWarehouseSetup(assignments)

    val moveInstructions: MoveInstruction = parseMoveInstruction(assignments)

    for (move in moveInstructions) {
        warehouse = warehouse.move(move.first, move.second, move.third)
    }
    // receive top crates, i.e., the crates at the beginning of each list
    return warehouse.getTopCrates()
}

fun parseWarehouseSetup(assignments: List<String>): Map<Int, String> {
    val warehouse = mutableMapOf(1 to "", 2 to "", 3 to "", 4 to "", 5 to "", 6 to "", 7 to "", 8 to "", 9 to "")
    for (line in assignments) {
        if (line == " 1   2   3   4   5   6   7   8   9") break
        val match = warehouseRegex.findAll(line).toList()
        for (column in warehouse.keys) {
            if (match.size >= column) {
                val currentGroup = match[column - 1].groups[0]?.value?.get(1).toString()
                println(currentGroup)
                if (currentGroup != " ") {
                    warehouse[column] = currentGroup + warehouse[column]
                    println(warehouse)
                }
            }

        }
    }
    return warehouse
}

fun parseMoveInstruction(
    assignments: List<String>
): MoveInstruction {
    val moveInstructions: MoveInstruction = mutableListOf()
    for (line in assignments) {
        val match = moveRegex.matchEntire(line)
        if (match != null) {
            moveInstructions.add(
                Triple(
                    match.groups[1]!!.value.toInt(),
                    match.groups[2]!!.value.toInt(),
                    match.groups[3]!!.value.toInt()
                )
            )
        }
    }
    return moveInstructions
}


fun Warehouse.move(number: Int, from: Int, to: Int): Warehouse {
    val newWarehouse = this.toMutableMap()
    for (count in 1..number) {
        val movedCrate: Crate = newWarehouse[from]!![0].toString()
        newWarehouse[from] = newWarehouse[from]!!.slice(1 until newWarehouse[from]!!.length)
        newWarehouse[to] = movedCrate + newWarehouse[to]
    }
    return newWarehouse
}

fun Warehouse.getTopCrates(): String {
    var output = ""
    for (key in this) {
        output += key.value.first()
    }
    return output
}