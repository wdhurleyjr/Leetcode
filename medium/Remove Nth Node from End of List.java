/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

Process:
1. Traverse the list to count the total number of nodes. This gives the length of the list, `count`.
2. Normalize `n` by calculating the zero-based index of the node to remove from the start of the list: `n = count - n`.
3. Handle the edge case where the node to be removed is the head (i.e., when `n == 0`). Return `head.next` in this case.
4. Traverse the list again to find the node just before the target node (at index `n - 1`).
5. Update the `next` pointer of the node before the target to skip the target node, effectively removing it.
6. Return the modified head of the linked list.

This two-pass approach ensures simplicity while maintaining efficiency with O(n) time complexity and O(1) space complexity.
*/

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode node1 = head;
        while (node1 != null) {
            node1 = node1.next;
            count++;
        }
        n = count - n;
        if (n == 0) {
            return head.next;
        }
        count = 0;
        ListNode node2 = head;
        while (node2 != null) {
            if (count == n - 1) {
                node2.next = node2.next.next;
            }
            node2 = node2.next;
            count++;
        }
        return head;
    }
}

