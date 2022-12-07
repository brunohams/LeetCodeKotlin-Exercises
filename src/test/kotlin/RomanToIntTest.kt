import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class RomanToIntTest {

    private val solution = Solution()

    @Test
    fun test_1_through_10() {
        val mapAnswers = mapOf(
            "I" to 1,
            "II" to 2,
            "III" to 3,
            "IV" to 4,
            "V" to 5,
            "VI" to 6,
            "VII" to 7,
            "VIII" to 8,
            "IX" to 9,
            "X" to 10
        )
        mapAnswers.forEach { (roman, number) ->
            assertEquals(number, solution.romanToInt(roman))
        }
    }

    @Test
    fun test_11_through_100() {
        val mapAnswers = mapOf(
            "XI" to 11,
            "XV" to 15,
            "XIX" to 19,
            "XXIV" to 24,
            "XXXIX" to 39,
            "XL" to 40,
            "L" to 50,
            "LV" to 55,
            "LXI" to 61,
            "LXXIV" to 74,
            "LXXX" to 80,
            "LXL" to 90,
            "C" to 100
        )
        mapAnswers.forEach { (roman, number) ->
            assertEquals(number, solution.romanToInt(roman))
        }
    }
}