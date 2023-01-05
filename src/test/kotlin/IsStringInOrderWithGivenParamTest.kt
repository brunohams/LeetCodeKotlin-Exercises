import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsStringInOrderWithGivenParamTest {

    private val solution = Solution()

    @Test
    fun valid() {
        assertTrue { solution.isStringInOrderWithGivenParam("axxbxxcxxd","abcd") }
    }

    @Test
    fun invalid() {
        assertFalse { solution.isStringInOrderWithGivenParam("axxbxxdxxxxc","abcd") }
        assertFalse { solution.isStringInOrderWithGivenParam("axxabxxxcd","abcd") }
    }

}