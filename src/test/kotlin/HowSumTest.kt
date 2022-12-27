import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class HowSumTest {

    private val solution = Solution()

    @Test
    fun test_memoization() {
        assertEquals(
            listOf(3,2,2),
            solution.howSumMemoized(7, listOf(2,3))
        )
        assertEquals(
            listOf(4,3),
            solution.howSumMemoized(7, listOf(5,3,4,7))
        )
        assertEquals(
            listOf(2,2,2,2),
            solution.howSumMemoized(8, listOf(2,3,5))
        )
        assertEquals(
            null,
            solution.howSumMemoized(7, listOf(2,4))
        )
        assertEquals(
            null,
            solution.howSumMemoized(300, listOf(7,14))
        )
    }

    @Test
    fun test_tabulation() {
        assertEquals(
            listOf(3,2,2),
            solution.howSumTabulation(7, listOf(2,3))
        )
        assertEquals(
            listOf(4,3),
            solution.howSumTabulation(7, listOf(5,3,4,7))
        )
        assertEquals(
            listOf(2,2,2,2),
            solution.howSumTabulation(8, listOf(2,3,5))
        )
        assertEquals(
            null,
            solution.howSumTabulation(7, listOf(2,4))
        )
        assertEquals(
            null,
            solution.howSumTabulation(300, listOf(7,14))
        )
    }
}