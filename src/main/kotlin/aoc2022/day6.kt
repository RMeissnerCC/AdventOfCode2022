package aoc2022

import utils.loadData

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)
fun main() {

    val fileName = "src/main/resources/aoc2022/day6"
    val signals = loadData(fileName).first()
    var output = firstTask(signals)

    println(output)
    output = secondTask(signals)

    println(output)
    // parse data as sets? sliding window, with only unique characters?
}

fun firstTask(signals: String): Int {
    return findUniques(signals,4)
}

fun secondTask(signals: String): Int {
    return findUniques(signals,14)
}

private fun findUniques(signals: String,length:Int): Int {
    val windows = signals.windowed(length, 1, true)
    val signalWindows = windows.map {
        it.allUnique()
    }
    val index = signalWindows.indexOf(true) + length
    println(signalWindows)
    println(signalWindows[index])
    println(windows[index])

    return index
}
