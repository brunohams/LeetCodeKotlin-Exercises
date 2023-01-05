import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CountConstructTest {

    private val solution = Solution()

    @Test
    fun test_memoization() {
        assertEquals(
            2,
            solution.countConstructMemo("purple", listOf("purp", "p", "ur", "le", "purpl")),
        )
        assertEquals(
            1,
            solution.countConstructMemo("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))
        )
        assertEquals(
            0,
            solution.countConstructMemo("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))
        )
        assertEquals(
            4,
            solution.countConstructMemo("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))
        )
        assertEquals(
            0,
            solution.countConstructMemo("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee"))
        )
    }

    @Test
    fun test_tabulation() {
        assertEquals(
            2,
            solution.countConstructTabulation("purple", listOf("purp", "p", "ur", "le", "purpl")),
        )
        assertEquals(
            1,
            solution.countConstructTabulation("abcdef", listOf("ab", "abc", "cd", "def", "abcd"))
        )
        assertEquals(
            0,
            solution.countConstructTabulation("skateboard", listOf("bo", "rd", "ate", "t", "ska", "sk", "boar"))
        )
        assertEquals(
            4,
            solution.countConstructTabulation("enterapotentpot", listOf("a", "p", "ent", "enter", "ot", "o", "t"))
        )
        assertEquals(
            0,
            solution.countConstructTabulation("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef", listOf("e", "ee", "eee", "eeee", "eeeee", "eeeeee"))
        )
    }

}