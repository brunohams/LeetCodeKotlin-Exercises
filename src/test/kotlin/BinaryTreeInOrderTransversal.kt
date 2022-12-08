import org.junit.jupiter.api.Test
import struct.TreeNode
import kotlin.test.assertEquals

class BinaryTreeInOrderTransversal {

    private val solution = Solution()

    @Test
    fun test_Example1() {
        val root = TreeNode(1).apply {
            right = TreeNode(2).apply {
                left = TreeNode(3)
            }
        }
        assertEquals(listOf(1,3,2), solution.inorderTraversal(root))
    }

}