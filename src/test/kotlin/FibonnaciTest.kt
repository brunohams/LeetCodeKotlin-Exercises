import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.test.assertEquals

class FibonnaciTest {

    private val solution = Solution()

    @Test
    fun test_Example1() {
        println(solution.fibonacciWithMemoization(500))
        println(solution.fibonacciResult)
        assertEquals(21, solution.fibonacciWithMemoization(8))
    }

}