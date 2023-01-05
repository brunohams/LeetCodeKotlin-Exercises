import org.junit.jupiter.api.Test
import struct.TreeNode
import java.text.SimpleDateFormat
import java.time.Duration
import java.time.LocalDate
import java.util.Date
import kotlin.test.assertContains
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AllConstructTest {

    private val solution = Solution()

    @Test
    fun test_memoization() {
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

    @Test
    fun test_tabulation() {
//        assertTrue {
//            listOf(
//                listOf("ab", "cd", "ef"),
//                listOf("ab", "c", "def"),
//                listOf("abc", "def"),
//                listOf("abcd", "ef")
//            ).containsAll(
//                solution.allConstructTabulation("abcdef", listOf("ab", "abc", "cd", "def", "abcd", "ef", "c"))
//            )
//        }
//
//        println(solution.allConstructTabulation("bruno", listOf("o", "br", "cd", "b", "brun", "ef", "run", "r", "u", "n", "bruno")))
//
//        assertEquals(
//            listOf(null),
//            solution.allConstructTabulation("hello", listOf("cat", "dog", "mouse"))
//        )
//
//        assertEquals(
//            listOf(listOf()),
//            solution.allConstructTabulation("", listOf("cat", "dog", "mouse"))
//        )

        assertEquals(
            listOf(null),
            solution.allConstructTabulation("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaz", listOf("aa", "a", "aaa", "aaaa", "aaaaa"))
        )
    }


}