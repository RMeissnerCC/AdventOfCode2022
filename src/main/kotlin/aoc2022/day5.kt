package aoc2022

import utils.loadData

typealias Warehouse = Map<Int, String>

fun main() {

    val fileName = "src/main/resources/aoc2022/day5"
    val assignments = loadData(fileName)

    // parse crate setup
    for (line in assignments) {
        println(line)
        println(line.chunked(4))
    }

    // parse move instructions

    var warehouse = mapOf(1 to "CMK", 2 to "KDM")
    // apply move instructions
    // Try to: move 1 from 1 to 2
    warehouse = warehouse.move(1, 1, 2)


    // receive top crates, i.e., the crates at the beginning of each list
    println(warehouse)
    val output = warehouse.getTopCrates()
    println("Final order of crates: $output")
}

fun Warehouse.move(number: Int, from: Int, to: Int): Warehouse {
    var newWarehouse = this.toMutableMap()
    println(newWarehouse[from])
    println(newWarehouse[to])
    println(newWarehouse[from]?.slice(0 until number))

    // Todo how to split here?!
//    newWarehouse[from] = newWarehouse[from].slice(number .. newWarehouse[from].length)
    newWarehouse[to] = newWarehouse[from]?.slice(0 until number) + newWarehouse[to]

    return newWarehouse
}

fun Warehouse.getTopCrates(): String {
    var output = ""
    for (key in this) {
        output += key.value.first()
    }
    return output
}