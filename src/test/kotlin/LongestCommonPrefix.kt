import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class LongestCommonPrefix {

    private val solution = Solution()

    @Test
    fun testInit() {
        assertNotNull(solution.longestCommonPrefix(arrayOf("a")))
    }

    @Test
    fun testGoodData() {
        val given = arrayOf("flower","flow","flight")
        assertEquals("fl", solution.longestCommonPrefix(given))
    }

    @Test
    fun testBadData() {
        val given = arrayOf("dog","racecar","car")
        assertEquals("", solution.longestCommonPrefix(given))
    }

    @Test
    fun testGoodData02() {
        val given = arrayOf("cir","car")
        assertEquals("c", solution.longestCommonPrefix(given))
    }

}