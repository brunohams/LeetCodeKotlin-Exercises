import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CanConstructTest {

    private val solution = Solution()

    @Test
    fun test_memoization() {
        assertEquals(
            true,
            solution.canConstructMemo("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))
        )
        assertEquals(
            true,
            solution.canConstructMemo("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))
        )
        assertEquals(
            false,
            solution.canConstructMemo("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))
        )
        assertEquals(
            false,
            solution.canConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee"))
        )
    }

    @Test
    fun test_tabulation() {
        assertEquals(
            true,
            solution.canConstructTabulation("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))
        )
        assertEquals(
            true,
            solution.canConstructTabulation("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))
        )
        assertEquals(
            false,
            solution.canConstructTabulation("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))
        )
        assertEquals(
            false,
            solution.canConstructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee"))
        )
    }


}