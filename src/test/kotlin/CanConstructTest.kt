import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CanConstructTest {

    private val solution = Solution()

    @Test
    fun test_valid() {
        assertEquals(
            true,
            solution.canConstructMemo("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))
        )
        assertEquals(
            true,
            solution.canConstructMemo("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))
        )
    }

    @Test
    fun test_invalid() {
        assertEquals(
            false,
            solution.canConstructMemo("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))
        )
        assertEquals(
            false,
            solution.canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee"))
        )
    }


}