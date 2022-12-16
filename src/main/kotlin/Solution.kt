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

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        val tmpRight = root.right
        root.right = root.left
        root.left = tmpRight
        invertTree(root.left)
        invertTree(root.right)
        return root
    }

    fun longestPalindrome(s: String): String {
        if (s.isEmpty()) return ""
        if (s.length == 1) return s

        var palindrome = ""

        // b.a.b.a.d
        for (i in s.indices) {

            // b.a.b.a.d
            for (j in i .. s.lastIndex) {

                val substring = s.substring(i, j+1)
                var isPalindrome = true
                var counter = 0

                for (n in 0 .. substring.length / 2) {
                    if (substring[n] != substring[substring.lastIndex-counter]) {
                        isPalindrome = false
                        break
                    }
                    counter++
                }

                if (isPalindrome && substring.length > palindrome.length) {
                    palindrome = substring
                }

            }

        }

        return palindrome
    }
}


// With one pointer it doesn't work =(
// b.a.b.a.d
// ^
// b.a.b.a.d -> bab
//   ^
// b.a.b.a.d -> aba
//     ^
// b.a.b.a.d
//       ˆ

// c.b.b.d
// ^
// c.b.b.d
//   ^
// c.b.b.d
//     ^

// o.v.v.o
// ^
// o.v.v.o
//   ˆ
// o.v.v.o
//     ˆ

// two pointers (left -> right -> both)
// b.a.b.a.d -> b
// ˆ2
// b.a.b.a.d
// ^ ^ *
// b.a.b.a.d -> bab & aba
// * ^ ^ *
// b.a.b.a.d
//     ^ ^

// o.v.v.o
// ^ ^
// o.v.v.o
//   ^ ^




// PAR
// o.v.v.o -> o
// ^ ^
// o.v.v.o -> o.v.v.o
//   ^ ^
//   ^ ^
// ^     ^

// a.a.e.e.v.o.o.v.e.a
// ^ ^
// ^ ^ -> aa
// a.a.e.e.v.o.o.v.e.a
//   ^ ^
// a.a.e.e.v.o.o.v.e.a
//     ^ ^
//     ^ ^ -> ee
// a.a.e.e.v.o.o.v.e.a
//       ^ ^
// a.a.e.e.v.o.o.v.e.a
//         ^ ^
// a.a.e.e.v.o.o.v.e.a
//           ^ ^
//           ^ ^ -> oo
//         ^     ^ -> voov
//       ^         ^ -> evoove


// a.a.e.e.v.o.o.v.e.a
//






// IMPAR? GREAT SUCCESS
// o.v.v.v.v.v.o -> o
// ^
// o.v.v.v.v.v.o
//   ^
// o.v.v.v.v.v.o -> v.v.v
//     ^
//   ^   ^
// o.v.v.v.v.v.o -> o.v.v.v.v.v.o
//       ^
//     ^   ^
//   ^       ^
// ^           ^

// a.b.b.b.c.d.a -> a
// ^
// a.b.b.b.c.d.a
//   ^
// a.b.b.b.c.d.a -> bbb
//     ^
//   ^   ^
// a.b.b.b.c.d.a
//       ^
// a.b.b.b.c.d.a
//         ^

