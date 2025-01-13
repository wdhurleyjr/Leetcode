/*
Notes:

Time Complexity: O(n)
- Each operation in the input array is processed exactly once.
- Iterating through the stack to compute the total sum also takes O(n), making the overall time complexity O(n).

Space Complexity: O(n)
- The stack can hold up to n integers, where n is the number of operations in the input.

Algorithm Explanation:
1. Initialize a stack to store valid scores.
2. Iterate through the operations array:
   - If the operation is "+":
     - Pop the top value, peek at the next value, calculate their sum, and push both the popped value and the sum back onto the stack.
   - If the operation is "D":
     - Push twice the value of the top element of the stack onto the stack.
   - If the operation is "C":
     - Remove the top element from the stack.
   - Otherwise, parse the numeric string and push it onto the stack.
3. After processing all operations, iterate through the stack to calculate the total sum of scores.
4. Return the calculated total sum.
*/


class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <  operations.length; i++) {
            if(operations[i].equals("+")) {
                int popped = stack.pop();
                int peeked = stack.peek();
                stack.push(popped);
                stack.push(popped + peeked);
            } else if (operations[i].equals("D")) {
                int prev = stack.peek();
                stack.push(2 * prev);
            } else if (operations[i].equals("C")) {
                stack.pop();
            } else {
                int num = Integer.parseInt(operations[i]);
                stack.push(num);
            }
        }
        int sum = 0;
        for(int score : stack) {
            sum += score;
        }
        return sum;
    }
}