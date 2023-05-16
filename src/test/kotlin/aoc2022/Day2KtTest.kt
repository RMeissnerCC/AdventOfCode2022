package aoc2022

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day2KtTest {
    @Test
    fun testScore() {
        val map = getMap()
        assertEquals(3 + 1, getScore("A", "X",map))
        assertEquals(6 + 2, getScore("A", "Y",map))
        assertEquals(0 + 3, getScore("A", "Z",map))

        assertEquals(0 + 1, getScore("B", "X",map))
        assertEquals(3 + 2, getScore("B", "Y",map))
        assertEquals(6 + 3, getScore("B", "Z",map))

        assertEquals(6 + 1, getScore("C", "X",map))
        assertEquals(0 + 2, getScore("C", "Y",map))
        assertEquals(3 + 3, getScore("C", "Z",map))
    }

    @Test
    fun testMapping() {

        val map = getMap()
        var opponent = "A"
        var playerShould = "X"
        assertEquals(playerShould, convertOpponentToPlayerRecommendation(map, opponent))

        opponent = "B"
        playerShould = "Y"
        assertEquals(playerShould, convertOpponentToPlayerRecommendation(map, opponent))

        opponent = "C"
        playerShould = "Z"
        assertEquals(playerShould, convertOpponentToPlayerRecommendation(map, opponent))
    }

    @Test
    fun testDetermineScore() {
        val map = getMap()
        val data = listOf("A Y", "B X", "C Z")
        assertEquals(15, determineScore(data, map))

    }

    @Test
    fun testConvertPlayer(){
        val map = getMap()

        assertEquals("Z", convertPlayer("A","X", map))
    }

}