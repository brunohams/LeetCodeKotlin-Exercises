import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.system.measureTimeMillis
import kotlin.test.assertEquals

class GridTravelerTest {

    private val solution = Solution()

    @Test
    fun test_Example1() {
        assertEquals(1, solution.gridTraveler(1,1))
        assertEquals(3, solution.gridTraveler(2,3))
        assertEquals(3, solution.gridTraveler(3,2))
        assertEquals(6, solution.gridTraveler(3,3))
        assertEquals(2333606220, solution.gridTraveler(18,18))
    }

    @Test
    fun test_ExampleWithMemoization() {
        assertEquals(1, solution.gridTravelerWithMemoization(1,1))
        assertEquals(3, solution.gridTravelerWithMemoization(2,3))
        assertEquals(3, solution.gridTravelerWithMemoization(3,2))
        assertEquals(6, solution.gridTravelerWithMemoization(3,3))
        assertEquals(2333606220, solution.gridTravelerWithMemoization(18,18))
    }

    @Test
    fun test_ExampleWithTabulation() {
        assertEquals(1, solution.gridTravelerWithTabulation(1,1))
        assertEquals(3, solution.gridTravelerWithTabulation(2,3))
        assertEquals(3, solution.gridTravelerWithTabulation(3,2))
        assertEquals(6, solution.gridTravelerWithTabulation(3,3))
        assertEquals(2333606220, solution.gridTravelerWithTabulation(18,18))
    }

}