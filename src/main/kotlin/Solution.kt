import struct.TreeNode
import java.lang.Exception
import java.lang.IndexOutOfBoundsException
import kotlin.math.ceil
import kotlin.math.roundToInt

class Solution {
    fun isPalindrome(x: Int): Boolean {
        if (x in 0..9) {
            return true
        }

        val digits = x.toString()

        // Iterate for half of the array
        for (i in 0..digits.length.ushr(1)) {
            val rightIndex = digits.length-1
            if (digits[i] != digits[rightIndex-i]) {
                return false
            }
        }

        return true
    }

    fun romanToInt(s: String): Int {
        var counter = 0

        val valueMap = mapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        for (index in s.indices) {
            val currentChar = s.getOrNull(index) ?: throw IndexOutOfBoundsException("index: $index out of range")
            val nextChar = s.getOrNull(index+1)

            if (nextChar != null) {
                // Should decrement
                if (valueMap[currentChar]!! < valueMap[nextChar]!!) {
                    counter -= valueMap[currentChar]!!
                    continue
                }
            }

            counter += valueMap[currentChar]!!
        }

        return counter
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        var result: String = strs.firstOrNull() ?: ""

        for (stringIndex in 1 until strs.size) {
            var updatedValue = ""
            for (charIndex in strs[stringIndex].indices) {
                if (result.getOrNull(charIndex) != strs[stringIndex].getOrNull(charIndex)) {
                    break
                }
                updatedValue += strs[stringIndex][charIndex]
            }
            result = updatedValue
        }

        return result
    }

    val inorderTraversalResult = mutableListOf<Int>()

    fun inorderTraversal(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()
        inorderTraversal(root.left)
        inorderTraversalResult.add(root.`val`)
        inorderTraversal(root.right)
        return inorderTraversalResult
    }
}

// Left until null -> OK
// Root -> OK (required)
// Right -> OK



