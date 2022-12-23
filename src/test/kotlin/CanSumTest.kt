import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CanSumTest {

    private val solution = Solution()

    @Test
    fun test_true() {
        assertTrue { solution.canSumMemoized(7, listOf(2,3), hashMapOf()) }
        assertTrue { solution.canSumMemoized(8, listOf(2,3,5), hashMapOf()) }
        assertTrue { solution.canSumMemoized(7, listOf(5,3,4,7), hashMapOf()) }
    }

    @Test
    fun test_false() {
        assertFalse { solution.canSumMemoized(7, listOf(2,4), hashMapOf()) }
        assertFalse { solution.canSumMemoized(300, listOf(7,14), hashMapOf()) }
    }

}