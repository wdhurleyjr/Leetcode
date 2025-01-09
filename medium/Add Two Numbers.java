/*
Notes:

Time Complexity: O(m + n)
Space Complexity: O(m + n)

This solution efficiently handles the addition of two non-negative integers represented as linked lists.
Each node in the linked list represents a single digit of the number, stored in reverse order. The goal
is to compute the sum of these two numbers and return it as a new linked list in the same reverse order.

Algorithm:
1. Use a dummy node to simplify result list construction. This avoids handling edge cases for the head node.
2. Traverse both linked lists simultaneously, summing corresponding digits along with any carry from the
   previous step. If a list is shorter, treat its value as `0`.
3. Determine if there is a carry for the next digit using `if(sum > 9)` and store the current digit as `sum % 10`.
4. Append the result digit as a new node to the result list and advance pointers in both input lists if they are not null.
5. After the traversal, check if a carry remains and append it as a new node.
6. Return the next node of the dummy node as the head of the result list.

Edge Cases:
- Lists of different lengths (e.g., l1 = [9, 9], l2 = [1]).
- Input lists with only one node (e.g., l1 = [0], l2 = [0]).
- Carry resulting in an additional node at the end of the result list.

Example:
Input: l1 = [2, 4, 3], l2 = [5, 6, 4]
Output: [7, 0, 8] (Explanation: 342 + 465 = 807, stored as [7, 0, 8] in reverse order)
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode node = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = (l1 != null) ? l1.val : 0;
            int num2 = (l2 != null) ? l2.val : 0;
            int sum = num1 + num2 + carry;

            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }

            node.next = new ListNode(sum % 10);

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            node = node.next;
        }

        if (carry != 0) {
            node.next = new ListNode(1);
        }

        return dummy.next;
    }
}
