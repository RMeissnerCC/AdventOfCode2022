package aoc2022

import java.io.File

fun main() {
    val fileName = "src/main/resources/aoc2022/day1"
    var lines: List<String> = File(fileName).bufferedReader().readLines()
    println(lines)
    var calories = mutableListOf<Int>()
    var tmp = mutableListOf<Int>()

    for (line in lines) {
        println(line)
        if (line == "\n" || line.isEmpty()) {
            calories += tmp.sum()
            tmp = mutableListOf()
        } else
            tmp += line.replace("\n", "").toInt()
    }
    calories.sort()
    println(calories)
    println(calories.max())
    println(calories.slice(calories.size - 3..calories.size -1).sum())

}