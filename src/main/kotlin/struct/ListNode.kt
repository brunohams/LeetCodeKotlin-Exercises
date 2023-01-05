package struct

data class ListNode(var `val`: Int) {
    var next: ListNode? = null
//
//    override fun equals(other: Any?): Boolean {
//        when(other) {
//            is ListNode -> {
//
//                if (`val` != other.`val`) return false
//
//                var nextNode = next
//                while (nextNode != null) {
//                    if (nextNode.`val` != other.`val`) {
//                        return false
//                    }
//                    nextNode = next?.next
//                }
//
//                return true
//            }
//            else -> return false
//        }
//    }

//    override fun toString(): String {
//        var stringValue = "$`val`, "
//        var nextNode = next
//        while (nextNode != null) {
//            stringValue += "${nextNode.`val`}, "
//            nextNode = next?.next
//        }
//        return stringValue
//    }

}