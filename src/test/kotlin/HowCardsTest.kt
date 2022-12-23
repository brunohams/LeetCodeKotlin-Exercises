import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.test.*

class HowCardsTest {

    private val solution = Solution()

    @Test
    fun test_valid() {
        val expected = listOf(0,1,3)
        val actual = solution.howCards(listOf(1,2,3), listOf(1,2,4,3,5,2))
        assertTrue(expected.size == actual?.size && expected.containsAll(actual) && actual.containsAll(expected))

        actual?.forEach {
            println("You should combine them taking the ${it+1} card.")
        }
    }


}