
import kotlin.test.Test
import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @Test
    fun TestSum1() {
        val expected = 246.0
        assertEquals(expected, main("123+123"))
    }

    @Test
    fun TestSum2() {
        val expected = 0.0
        assertEquals(expected, main("123-123"))
    }

    @Test
    fun TestSum3() {
        val expected = -246.0
        assertEquals(expected, main("-123-123"))
    }

    @Test
    fun TestSum4() {
        val expected = 246.0
        assertEquals(expected, main("123+123+123-123"))
    }

    @Test
    fun TestSum5() {
        val expected= 0.0
        assertEquals(expected, main("-0+0+0+0-0"))
    }

    @Test
    fun TestMultiplication1() {
        val expected = 25.0
        assertEquals(expected, main("5*5"))
    }

    @Test
    fun TestMultiplication2() {
        val expected = 625.0
        assertEquals(expected, main("5*5*5*5"))
    }

    @Test
    fun TestMultiplication3() {
        val expected = 50.0
        assertEquals(expected, main("5*5+5*5"))
    }

    @Test
    fun TestMultiplication4() {
        val expected = 25.0
        assertEquals(expected, main("5*5+5-5"))
    }

    @Test
    fun TestMultiplication5() {
        val expected = -25.0
        assertEquals(expected, main("-5*5"))
    }

    @Test
    fun TestMultiplication6() {
        val expected = 155.0
        assertEquals(expected, main("5+5*5*5+5*5"))
    }

    @Test
    fun TestMultiplication7() {
        val expected = 25.0
        assertEquals(expected, main("-5*-5"))
    }

    @Test
    fun TestMultiplication8() {
        val expected = -25.0
        assertEquals(expected, main("5*-5"))
    }

    @Test
    fun TestDivision1() {
        val expected = 1.0
        assertEquals(expected, main("10/10"))
    }

    @Test
    fun TestDivision2() {
        val expected = 10.0
        assertEquals(expected, main("8/2*2+2"))
    }

    @Test
    fun TestDivision3() {
        val expected = 75.289
        assertEquals(expected, main("7.6/9*11+66"))
    }

    @Test
    fun TestDivision4() {
        val expected = 1.0
        assertEquals(expected, main("1000/10/10/10"))
    }

    @Test
    fun TestDivision5() {
        val expected: Double = Double.POSITIVE_INFINITY
        assertEquals(expected, main("1/0"))
    }

    @Test
    fun TestDivision6() {
        val expected = 1.0
        assertEquals(expected, main("1/1"))
    }



}