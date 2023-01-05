import struct.ListNode
import struct.TreeNode
import java.lang.IndexOutOfBoundsException
import kotlin.math.max

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

    var fibonacciResult = hashMapOf<Int, Long>()
    fun fibonacciWithMemoization(pos: Int): Long {
        if (pos <= 2) return 1
        if (fibonacciResult.containsKey(pos)) return fibonacciResult[pos]!!
        val result = fibonacciWithMemoization(pos - 1) + fibonacciWithMemoization(pos - 2)
        fibonacciResult[pos] = result
        return result
    }

    fun gridTraveler(row: Int, column: Int): Long {
        if (row == 1 && column == 1) return 1
        if (row == 0 || column == 0) return 0
        return gridTraveler(row - 1, column) + gridTraveler(row, column - 1)
    }

    var gridTravelerMap = hashMapOf<String, Long>()
    fun gridTravelerWithMemoization(row: Int, column: Int): Long {
        val key = "$row,$column"
        val secondaryKey = "$column,$row"

        if (gridTravelerMap.containsKey(key)) {
            return gridTravelerMap[key]!!
        }

        if (gridTravelerMap.containsKey(secondaryKey)) {
            return gridTravelerMap[secondaryKey]!!
        }

        if (row == 1 && column == 1) return 1
        if (row == 0 || column == 0) return 0

        val downTravels = gridTravelerWithMemoization(row - 1, column)
        val rightTravels = gridTravelerWithMemoization(row, column - 1)

        gridTravelerMap[key] = downTravels + rightTravels

        println("$key - ${gridTravelerMap[key]}")

        return gridTravelerMap[key]!!
    }

    fun canSum(target: Int, list: List<Int>): Boolean {
        if (target == 0) return true
        if (target < 0) return false

        list.forEach { num ->
            val remainder = target - num
            if (canSum(remainder, list)) {
                return true
            }
        }
        return false
    }

    fun canSumMemoized(target: Int, list: List<Int>, memoizedResult: HashMap<Int, Boolean>): Boolean {
        if (target == 0) return true
        if (target < 0) return false

        list.forEach { num ->
            val remainder = target - num
            if (memoizedResult.containsKey(remainder)) {
                return memoizedResult[remainder]!!
            } else {
                if (canSumMemoized(remainder, list, memoizedResult)) {
                    memoizedResult[remainder] = true
                    return true
                }
            }
        }
        memoizedResult[target] = false
        return false
    }

    fun howSum(target: Int, list: List<Int>): List<Int>?  {
        if (target == 0) return emptyList()
        if (target < 0) return null

        list.forEach { num ->
            val remainder = target - num
            val remainderResult = howSum(remainder, list)
            if (remainderResult != null) {
                return remainderResult + num
            }
        }
        return null
    }

    fun howSumMemoized(target: Int, list: List<Int>, memo: HashMap<Int, List<Int>?> = hashMapOf()): List<Int>?  {
        if (memo.containsKey(target)) return memo[target]
        if (target == 0) return emptyList()
        if (target < 0) return null

        list.forEach { num ->
            val remainder = target - num
            val remainderResult = howSumMemoized(remainder, list, memo)
            if (remainderResult != null) {
                memo[target] = remainderResult + num
                return memo[target]!!
            }
        }
        memo[target] = null
        return null
    }

    fun bestSum(target: Int, list: List<Int>): List<Int>? {
        if (target == 0) return emptyList()
        if (target < 0) return null

        var shortestCombination: List<Int>? = null

        list.forEach { num ->
            val remainder = target - num
            val result = bestSum(remainder, list)
            if (result != null) {
                val combination = result + num
                if (shortestCombination == null || combination.size < shortestCombination!!.size) {
                    shortestCombination = combination
                }
            }
        }

        return shortestCombination
    }

    fun bestSumMemoized(target: Int, list: List<Int>, memo: HashMap<Int, List<Int>?> = hashMapOf()): List<Int>? {
        if (memo.containsKey(target)) return memo[target]
        if (target == 0) return emptyList()
        if (target < 0) return null

        var shortestCombination: List<Int>? = null

        list.forEach { num ->
            val remainder = target - num
            val result = bestSumMemoized(remainder, list, memo)
            if (result != null) {
                val combination = result + num
                memo[target] = combination
                if (shortestCombination == null || combination.size < shortestCombination!!.size) {
                    shortestCombination = combination
                }
            }
        }

        memo[target] = shortestCombination
        return shortestCombination
    }

    fun howManyReais(target: Float, list: List<Float>, memo: HashMap<Float, List<Float>?> = hashMapOf()): List<Float>? {
        if (memo.containsKey(target)) return memo[target]
        if (target == 0.0f) return emptyList()
        if (target < 0.0f) return null
        println(target)

        var shortestCombination: List<Float>? = null

        list.forEach { num ->
            val remainder = target - num
            val result = howManyReais(remainder, list, memo)
            if (result != null) {
                val combination = result + num
                memo[target] = combination
                if (shortestCombination == null || combination.size < shortestCombination!!.size) {
                    shortestCombination = combination
                }
            }
        }

        memo[target] = shortestCombination
        return shortestCombination
    }

    fun canConstruct(target: String, wordBank: List<String>): Boolean {
        if (target == "") return true

        for (word in wordBank) {
            if (target.indexOf(word) == 0) {
                val suffix = target.slice(word.length until target.length)
                if (canConstruct(suffix, wordBank)) {
                    return true
                }
            }
        }

        return false
    }

    fun canConstructMemo(target: String, wordBank: List<String>, memo: HashMap<String, Boolean> = hashMapOf()): Boolean {
        if (memo.containsKey(target)) return memo[target]!!
        if (target == "") return true

        for (word in wordBank) {
            if (target.indexOf(word) == 0) {
                val suffix = target.slice(word.length until target.length)
                if (canConstructMemo(suffix, wordBank, memo)) {
                    memo[target] = true
                    return true
                }
            }
        }

        memo[target] = false
        return false
    }

    fun howCards(targetCards: List<Int>?, listOfCards: List<Int>): List<Int>? {
        if (targetCards == null) return null
        if (targetCards.isEmpty()) return emptyList()

        for (i in listOfCards.indices) {
            if (targetCards.first() == listOfCards[i]) {
                val result = howCards(targetCards.slice(1 until targetCards.size), listOfCards)
                if (result != null) {
                    return result + i
                }
            }
        }

        return null
    }

    fun countConstruct(target: String, wordBank: List<String>): Int {
        if (target == "") return 1

        var totalWays = 0

        wordBank.forEach { word ->
            if (target.indexOf(word) == 0) {
                val numWays = countConstruct(target.slice(word.length until target.length), wordBank)
                totalWays += numWays
            }
        }

        return totalWays
    }

    fun countConstructMemo(target: String, wordBank: List<String>, memo: HashMap<String, Int> = hashMapOf()): Int {
        if (memo.containsKey(target)) return memo[target]!!
        if (target == "") return 1

        var totalWays = 0

        wordBank.forEach { word ->
            if (target.indexOf(word) == 0) {
                val numWays = countConstructMemo(target.slice(word.length until target.length), wordBank, memo)
                totalWays += numWays
                memo[target] = numWays
            }
        }

        memo[target] = totalWays
        return totalWays
    }

    fun allConstruct(target: String, wordBank: List<String>): List<List<String>> {
        if (target == "") return listOf(listOf())

        val constructWays = mutableListOf<List<String>>()

        wordBank.forEach { word ->
            if (target.indexOf(word) == 0) {
                val suffix = target.slice(word.length until target.length)
                val suffixWays = allConstruct(suffix, wordBank)
                val targetWays = suffixWays.map { way -> way.plus(word).sortedBy { it } }
                constructWays.addAll(targetWays)
            }
        }

        return constructWays
    }

    fun allConstructMemo(target: String, wordBank: List<String>, memo: HashMap<String, List<List<String>>> = hashMapOf()): List<List<String>> {
        if (memo.containsKey(target)) return memo[target]!!
        if (target == "") return listOf(listOf())

        val constructWays = mutableListOf<List<String>>()

        wordBank.forEach { word ->
            if (target.indexOf(word) == 0) {
                val suffix = target.slice(word.length until target.length)
                val suffixWays = allConstructMemo(suffix, wordBank, memo)
                val targetWays = suffixWays.map { way -> way.plus(word).sortedBy { it } }
                constructWays.addAll(targetWays)
                memo[target] = targetWays
            }
        }

        memo[target] = constructWays
        return constructWays
    }

    fun fibonacciWithTabulation(n: Int): Long {
        val table = LongArray(n + 1) { 0 }
        table[1] = 1
        // [0, 1, 0,0,0,0,0]
        for (i in table.indices) {
            if (table.indices.contains(i+1)) {
                table[i+1] += table[i]
            }
            if (table.indices.contains(i+2)) {
                table[i+2] += table[i]
            }
        }

        return table[n]
    }

    fun gridTravelerWithTabulation(row: Int, column: Int): Long {
        val map = Array(row + 1) { Array(column + 1) { 0L } }
        map[1][1] = 1
        for (rowIndex in 0 .. row) {
            for (columnIndex in 0 .. column) {
                // [0,0,0]
                // [0,0,0]
                // [0,0,0]
                if (map.indices.contains(rowIndex+1)) {
                    map[rowIndex+1][columnIndex] += map[rowIndex][columnIndex]
                }
                if (map[rowIndex].indices.contains(columnIndex+1)) {
                    map[rowIndex][columnIndex+1] += map[rowIndex][columnIndex]
                }
            }
        }
        return map[row][column]
    }

    fun howSumTabulation(target: Int, nums: List<Int>): List<Int>? {
        val table: Array<MutableList<Int>?> = Array(target + 1) { null }
        table[0] = mutableListOf()

        for (i in table.indices) {
            if (table[i] == null) continue
            nums.forEach { num ->
                val setPosition = i+num
                if (setPosition <= table.lastIndex) {
                    if (table[setPosition] == null) {
                        table[setPosition] = mutableListOf()
                    }
                    table[setPosition] = table[i]!!.plus(num).toMutableList()
                }
            }
        }

        return table[target]
    }

    fun bestSumTabulation(target: Int, numbers: List<Int>): List<Int>? {
        val table = Array<MutableList<Int>?>(target + 1) { null }
        table[0] = mutableListOf()

        for (tableIndex in table.indices) {
            if (table[tableIndex] == null) continue
            for (number in numbers) {
                if ((tableIndex + number) <= table.lastIndex) {

                    if (table[tableIndex + number] == null) {
                        table[tableIndex + number] = mutableListOf()
                    }

                    val combination = table[tableIndex]?.plus(number)!!
                    val existentList = table[tableIndex + number]!!

                    if (combination.size <= existentList.size || existentList.isEmpty()) {
                        table[tableIndex + number] = combination.toMutableList()
                    }
                }
            }
        }

        return table[target]?.toList()
    }

    fun canConstructTabulation(target: String, wordBank: List<String>): Boolean {
        val table = Array<Boolean>(target.length + 1) { false }
        table[0] = true

        for (i in target.indices) {
            if (!table[i]) continue
            for (word in wordBank) {
                if (i + word.length <= target.length) {
                    val slicedTarget = target.slice(i until i + word.length)
                    if (slicedTarget == word) {
                        table[i + word.length] = true
                    }
                }
            }
        }

        return table[target.length]
    }

    fun countConstructTabulation(target: String, wordBank: List<String>): Int {
        val table = Array<Int>(target.length + 1) { 0 }
        table[0] = 1

        for (i in target.indices) {
            if (table[i] == 0) continue
            for (word in wordBank) {
                if (i + word.length <= target.length) {
                    val slicedTarget = target.slice(i until i + word.length)
                    if (slicedTarget == word) {
                        table[i + word.length] += table[i]
                    }
                }
            }
        }

        return table[target.length]
    }

    fun allConstructTabulation(target: String, wordBank: List<String>): List<List<String>?> {
        val table = Array<List<List<String>?>>(target.length + 1) { listOf(null) }
        table[0] = listOf(listOf())

        for (i in target.indices) {
            if (table[i].first() == null) continue
            for (word in wordBank) {
                if (i + word.length <= target.length) {
                    val slicedTarget = target.slice(i until i + word.length)
                    if (slicedTarget == word) {
                        val newCombinations = table[i].map { subArray ->
                            subArray?.plus(word)
                        }
                        table[i + word.length] = table[i + word.length]
                            .plus(newCombinations)
                            .mapNotNull { it }
                    }
                }
            }

        }

        return table[target.length]
    }


    var resultPalindrome = ""
    fun longestPalindrome2(target: String): String {
        for (i in target.indices) {
            // Check for odd
            expandThroughString(target, i, i + 1)
            // Check for even
            expandThroughString(target, i, i)
        }
        return resultPalindrome
    }

    fun expandThroughString(string: String, _r: Int, _l: Int) {
        var leftPosition = _l
        var rightPosition = _r
        while (
            string.getOrNull(rightPosition) != null && string.getOrNull(leftPosition) != null
            &&
            string.getOrNull(rightPosition) == string.getOrNull(leftPosition)
        ) {
            val newPalindrome = string.slice(leftPosition .. rightPosition)
            if (newPalindrome.length >= resultPalindrome.length) {
                resultPalindrome = newPalindrome
            }
            leftPosition--
            rightPosition++
        }
    }

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null

        val firstValue = l1?.`val` ?: 0
        val secondValue = l2?.`val` ?: 0
        var sumValue = firstValue + secondValue

        if (sumValue > 9) {
            l1?.next?.`val`?.let {
                l1.next?.`val` = it + 1
            } ?: kotlin.run {
                l1?.next = ListNode(1)
            }
            sumValue %= 10
        }

        return ListNode(sumValue).apply {
            next = addTwoNumbers(l1?.next, l2?.next)
        }
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val charSet = mutableSetOf<Char>()
        var longestLength = 0

        var left = 0
        var right = 0

        while (right < s.length) {

            // While the char got repeated, shift left
            while (charSet.contains(s[right])) {
                // Decrement left char by 1
                charSet.remove(s[left])
                left++
            }

            // Increment right char by 1
            charSet.add(s[right])

            // Set the max of longestLength
            // Or the right - left +1 (if no ever repeated)
            longestLength = Math.max(longestLength, right - left+1)

            right++
        }

        return longestLength
    }

    fun isStringInOrderWithGivenParam(order: String, s: String): Boolean {
        var position = 0

        for (char in s) {

            val indexOfChar = order.indexOf(char)

            // If in invalid position
            if (indexOfChar > position) {
                return false
            }

            // Invalid character - Continue...
            if (indexOfChar == -1) {
                continue
            }

            position++

        }

        return true
    }

}

// dvdf
// d
// dv
// dvd


// abcdefghai1234567890
// abcdefgh
// a
// bcdefghai1234567890
