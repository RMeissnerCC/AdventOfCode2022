package aoc2022

import utils.loadData
import java.nio.file.Paths

typealias Guide = Map<String, String>

fun getScore(opponent: String, player: String, map: Guide): Int {

    val playerShould = convertOpponentToPlayerRecommendation(map, opponent)
    var matchScore = 0 // lost
    if (playerShould == player) {
        matchScore = 3 // draw, score is 3
    } else if ((playerShould == "X" && player == "Y") || (playerShould == "Z" && player == "X") || (playerShould == "Y" && player == "Z")) {
        matchScore = 6 // win, score is 6
    }

    var shapeScore: Int = 0
    when (player) {
        "X" -> shapeScore = 1
        "Y" -> shapeScore = 2
        "Z" -> shapeScore = 3
    }
    return matchScore + shapeScore
}

fun main() {
    val path = Paths.get("").toAbsolutePath().toString()
    println("Working Directory = $path")

    val fileName = "AdventOfCode2022Kotlin/src/main/resources/aoc2022/day2"

    // A, X = Rock, B, Y = Paper, C, Z = Scissor
    val data = loadData(fileName)
    println(determineScore(data, getMap()))
    println("With correct decryption: ${determineScoreCorrectEncrypted(data, getMap())}")

}

fun determineScoreCorrectEncrypted(data: List<String>, map: Guide): Int {
    var totalScore = 0
    for (line in data) {
        val opponent = line[0].toString()
        val playerTruth = line[2].toString()
        val playerActual = convertPlayer(opponent, playerTruth, map)
        val score = getScore(opponent, playerActual, map) // calculate score for that round
        println("Match: $opponent vs. $playerActual : ${opponent == playerActual}-> $score")
        totalScore += score // add score for that round to total score
    }
    return totalScore

}

fun getLoose(input: String): String {
    var output = ""
    when (input) {
        "A" -> output = "Z"
        "B" -> output = "X"
        "C" -> output = "Y"
    }
    return output
}

fun getWin(input: String): String {
    var output = ""
    when (input) {
        "A" -> output = "Y"
        "B" -> output = "Z"
        "C" -> output = "X"
    }
    return output
}

fun convertPlayer(opponent: String, playerTruth: String, map: Guide): String {
    var actual = ""
    when (playerTruth) {
        "X" -> actual = getLoose(opponent)
        "Y" -> actual = convertOpponentToPlayerRecommendation(map, opponent)
        "Z" -> actual = getWin(opponent)
    }
    return actual
}

fun getMap(): Guide {
    return mapOf("A" to "X", "B" to "Y", "C" to "Z") // store the strategy guide in a map
}


fun determineScore(data: List<String>, map: Guide): Int {
    var totalScore = 0
    for (line in data) {
        val opponent = line[0].toString()
        val playerTruth = line[2].toString()
        val score = getScore(opponent, playerTruth, map) // calculate score for that round
        totalScore += score // add score for that round to total score
    }
    return totalScore
}

fun convertOpponentToPlayerRecommendation(map: Guide, opponent: String): String {
    return map[opponent]!! // player's recommended play from strategy guide
}
