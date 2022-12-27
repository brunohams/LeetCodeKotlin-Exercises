import org.junit.jupiter.api.Test
import struct.TreeNode
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.util.Date
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AllConstructTest {

    private val solution = Solution()

    @Test
    fun test_valid() {
        assertEquals(
            listOf(
                listOf("ab", "cd", "ef"),
                listOf("ab", "c", "def"),
                listOf("abc", "def"),
                listOf("abcd", "ef")
            ),
            solution.allConstructMemo("abcdef", listOf("ab", "abc", "cd", "def", "abcd", "ef", "c"))
        )

        println(solution.allConstructMemo("bruno", listOf("o", "br", "cd", "b", "brun", "ef", "run", "r", "u", "n", "bruno")))
    }

    @Test
    fun test_invalid() {
        assertEquals(
            emptyList(),
            solution.allConstructMemo("hello", listOf("cat", "dog", "mouse"))
        )

        assertEquals(
            listOf(listOf()),
            solution.allConstructMemo("", listOf("cat", "dog", "mouse"))
        )

        assertEquals(
            emptyList(),
            solution.allConstructMemo("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", listOf("aa", "a", "aaa", "aaaa", "aaaaa"))
        )
    }


}