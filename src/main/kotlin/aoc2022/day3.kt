package aoc2022

import utils.loadData


fun firstCompartment(input: String): String {
    return input.slice(0 until input.length / 2)
}

fun secondCompartment(input: String): String {
    return input.slice(input.length / 2 until input.length)
}


fun main() {

    val fileName = "AdventOfCode2022Kotlin/src/main/resources/aoc2022/day3"
    val rucksacks = loadData(fileName)

    var sum = sumOfPriorities(rucksacks)
    println("Total sum of priorities $sum")

    val groupedElfs = rucksacks.withIndex().groupBy { it.index / 3 }.asSequence()
    sum = 0
    for (group in groupedElfs) {
        var intersection = listOf<String>()
        for (item in group.value) {
            intersection = if (intersection.isEmpty()) stringToList(item.value)
            else intersection.intersect(stringToList(item.value).toSet()).toList()
        }
        val badge = intersection[0]
        println("intersection: $badge")
        val code = convertItemToPriority(badge)
        sum += code
    }

    println("Total sum of badge priorities $sum")
}

private fun sumOfPriorities(rucksacks: List<String>): Int {
    var sum = 0
    for (rucksack in rucksacks) {
        val first = firstCompartment(rucksack)
        val second = secondCompartment(rucksack)
        val wrongItem = compartmentToFirstCommonItem(first, second)
        val code = convertItemToPriority(wrongItem)
        sum += code
    }
    return sum
}

fun convertItemToPriority(wrongItem: String): Int {
    var code = wrongItem.toCharArray().first().code
    code -= if (code >= 97) 96
    else 65 - 26 - 1
    return code
}

fun compartmentToFirstCommonItem(first: String, second: String): String {
    val firstList = stringToList(first)
    val secondList = stringToList(second)
    return firstList.intersect(secondList.toSet()).first()
}

private fun stringToList(first: String) = first.toCharArray().map { it.toString() }