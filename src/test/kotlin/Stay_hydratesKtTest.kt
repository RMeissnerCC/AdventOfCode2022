import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Stay_hydratesKtTest{
    @Test
    fun testFixed() {
        assertEquals(1, litres(2.0))
        assertEquals(0, litres(1.4))
        assertEquals(6, litres(12.3))
        assertEquals(0, litres(0.82))
        assertEquals(5, litres(11.8))
        assertEquals(893, litres(1787.0))
        assertEquals(0, litres(0.0))
    }
}