/*
Notes:

Time Complexity:
- Push: O(n) for rearranging the queue after adding the new element.
- Pop: O(1) as it directly removes the front of the queue.
- Top: O(1) as it directly accesses the front of the queue.
- Empty: O(1) as it simply checks if the queue is empty.
Overall, the most expensive operation is `push`, making the average time complexity O(n).

Space Complexity:
- O(n): The queue can hold up to n elements, where n is the number of elements pushed onto the stack.

Algorithm Explanation:
1. Use a single queue (`q`) to simulate stack behavior.
2. Push operation:
   - Add the new element to the back of the queue.
   - Rotate all elements except the last added one (`size - 1`) to the back of the queue.
   - This ensures the most recently added element is always at the front, simulating a stack's "top."
3. Pop operation:
   - Directly remove and return the front element of the queue, which represents the "top" of the stack.
4. Top operation:
   - Return the front element of the queue without removing it.
5. Empty operation:
   - Check if the queue is empty, returning `true` or `false`.
*/

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty(); // Check if the queue is empty
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
