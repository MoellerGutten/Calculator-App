
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @Test
    fun TestSum1() {
        val expected: Double = 246.0
        assertEquals(expected, main("123+123"))
    }

    @Test
    fun TestSum2() {
        val expected: Double = 0.0
        assertEquals(expected, main("123-123"))
    }

    @Test
    fun TestSum3() {
        val expected: Double = -246.0
        assertEquals(expected, main("-123-123"))
    }

    @Test
    fun TestSum4() {
        val expected: Double = 246.0
        assertEquals(expected, main("123+123+123-123"))
    }

    @Test
    fun TestSum5() {
        val expected: Double = 0.0
        assertEquals(expected, main("-0+0+0+0-0"))
    }

    @Test
    fun TestMultiplication1() {
        val expected: Double = 25.0
        assertEquals(expected, main("5*5"))
    }

    @Test
    fun TestMultiplication2() {
        val expected: Double = 625.0
        assertEquals(expected, main("5*5*5*5"))
    }

    @Test
    fun TestMultiplication3() {
        val expected: Double = 25.0
        assertEquals(expected, main("5*5+5-5"))
    }

    @Test
    fun TestMultiplication4() {
        val expected: Double = -25.0
        assertEquals(expected, main("-5*5"))
    }

}