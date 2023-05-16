import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Digit_playKtTest{
    @Test
    fun testFixed() {
        assertEquals(1, digPow(89, 1))
        assertEquals(-1, digPow(92, 1))
        assertEquals(51, digPow(46288, 3))
        assertEquals(digPow(41, 5), 1025)
        assertEquals(digPow(8, 3), 512)
        assertEquals(digPow(114, 3), 1026)
    }
}