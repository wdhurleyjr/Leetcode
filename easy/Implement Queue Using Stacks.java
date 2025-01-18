/*
Notes:

Time Complexity:
- push: O(1)
- pop: Amortized O(1), Worst-case O(n)
- peek: Amortized O(1), Worst-case O(n)
- empty: O(1)

Space Complexity: O(n)

This implementation uses two stacks (`stack1` and `stack2`) to simulate the behavior of a queue, ensuring FIFO (First In, First Out) ordering. The operations utilize stack properties effectively, transferring elements between stacks only when necessary.

Algorithm Explanation:
1. **Push Operation (`push`)**:
   - Adds an element to the back of the queue.
   - Simply pushes the element onto `stack1`.

2. **Pop Operation (`pop`)**:
   - Removes and returns the element at the front of the queue.
   - If `stack2` is empty:
     - Transfer all elements from `stack1` to `stack2` to reverse their order.
   - Pop the top element from `stack2`, which represents the front of the queue.

3. **Peek Operation (`peek`)**:
   - Returns the element at the front of the queue without removing it.
   - Similar to `pop`, if `stack2` is empty, transfer elements from `stack1` to `stack2` to reverse their order.
   - Return the top element of `stack2`.

4. **Empty Check (`empty`)**:
   - Returns `true` if both `stack1` and `stack2` are empty.

Key Points:
- **Efficient Use of Stacks**: Elements are only transferred from `stack1` to `stack2` when `stack2` is empty, minimizing the cost of transfers.
- **FIFO Behavior**: The reversal of elements during the transfer ensures the correct order for queue operations.
- **Amortized Complexity**: Although individual transfers can be costly (\(O(n)\)), the amortized time complexity is \(O(1)\) due to the infrequent transfers.

Edge Cases:
- Empty Queue: Calling `pop` or `peek` on an empty queue may throw an exception, depending on the stack implementation.
- Single Element Queue: Handles pushing, peeking, and popping a single element correctly.
- Multiple Consecutive Operations: Ensures consistent behavior for a sequence of push, pop, and peek operations.
*/

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */