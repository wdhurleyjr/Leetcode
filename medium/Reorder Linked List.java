/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

This solution reorders a linked list in-place to achieve the specified order:
e.g., [1, 2, 3, 4, 5] becomes [1, 5, 2, 4, 3].

Steps:
1. **Find the Middle of the List**:
   - Use the slow and fast pointer technique to locate the midpoint of the list.
   - Slow pointer (`slow`) moves one step at a time, while the fast pointer (`fast`) moves two steps at a time.
   - When `fast` reaches the end, `slow` points to the middle of the list.

2. **Reverse the Second Half of the List**:
   - Starting from the node after the middle (`slow.next`), reverse the second half of the list.
   - Use three pointers (`prev`, `curr`, and `temp`) to reverse the direction of the links.
   - Set `slow.next = null` to disconnect the first half from the reversed second half.

3. **Merge the Two Halves**:
   - Alternate nodes from the first half and the reversed second half.
   - Use two pointers (`first` and `second`) to traverse the two halves, linking nodes in the required order.

Edge Cases:
- If the list is empty or contains only one node, no changes are needed.

Complexity:
- Time Complexity: O(n) because the list is traversed multiple times (finding the middle, reversing, and merging).
- Space Complexity: O(1) since all operations are done in place without using additional memory for new nodes or data structures.
*/

class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }
    }
}

