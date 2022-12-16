import org.junit.jupiter.api.Test
import kotlin.test.assertContains
import kotlin.test.assertEquals

class LongestPalindromeTest {

    private val solution = Solution()

    @Test
    fun testMultiplePalindrome() {
        val given = "babad"
        val expectedResults = listOf("bab", "aba")
        assertContains(expectedResults, solution.longestPalindrome(given))
    }

    @Test
    fun testSinglePalindrome() {
        val given = "cbbd"
        assertEquals("bb", solution.longestPalindrome(given))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("a", solution.longestPalindrome("a"))
    }

    @Test
    fun testTwoCharacters() {
        assertEquals("a", solution.longestPalindrome("ac"))
    }


    @Test
    fun test_bb() {
        assertEquals("bb", solution.longestPalindrome("bb"))
    }

}

// babad -> bab or aba
// cbbd -> bb
// abcde -> a or b or c or d or e
// aaaa bbbbbb -> bbbbbb


// b.a.b.a.d
// b
// ba
// bab <- eh
// baba
// babad

// a.b.a.d
// a
// ab
// aba <- eh
// abad

// b.a.d
// b
// b.a
// b.a.d

// a.d
// a
// a.d

// d
