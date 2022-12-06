import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PalindromeNumberTest {

    private val solution = Solution()

    @Test
    fun testOneDigitNumber() {
        for (x in 0..9) {
            assertEquals(true, solution.isPalindrome(x), "$x input should output true")
        }
    }

    @Test
    fun testPalindromeNumbers() {
        val palindromeNumbers = listOf(11, 151, 2882, 9009, 335533, 5555, 99099099)
        for (x in palindromeNumbers) {
            assertEquals(true, solution.isPalindrome(x), "$x input should output true")
        }
    }

    @Test
    fun testNonPalindromeNumbers() {
        val nonPalindromeNumbers = listOf(21, 546, 9822, 32656)
        for (x in nonPalindromeNumbers) {
            assertEquals(false, solution.isPalindrome(x), "$x input should output false")
        }
    }

    @Test
    fun testNegativeCharacters() {
        val numbers = listOf(-1, -3, -22, -32, -324, -5040, -550055)
        for (x in numbers) {
            assertEquals(false, solution.isPalindrome(x), "$x input should output false")
        }
    }

}