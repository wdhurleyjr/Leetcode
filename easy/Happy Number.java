/*
Notes:

Time Complexity: O(log(n))
- For each number `n`, the number of digits is approximately O(log(n)) in base 10.
- Summing the squares of the digits takes O(log(n)) operations.
- In the worst case, the sequence of numbers reduces to a small cycle or reaches `1`, which is bounded by the properties of the sum of squares of digits (numbers reduce to values <= 243 for any starting number). 
- Thus, the overall time complexity is O(log(n)) * O(c), where `c` is a constant.

Space Complexity: O(log(n))
- The `Set` stores numbers seen during the process.
- The size of the set is limited by the possible values of the sum of squares of digits, which is constrained by the maximum possible sum for numbers of a given size.

Algorithm Explanation:
1. **Purpose**:
   - Determine if a number `n` is a "happy number." A happy number is one that eventually reduces to `1` when repeatedly replaced by the sum of the squares of its digits. If the sequence enters a cycle that does not include `1`, the number is not happy.

2. **Cycle Detection Using a Set**:
   - Use a `HashSet` to store numbers that have already been seen in the sequence.
   - If a number is seen again, it means a cycle has been detected, and `n` is not happy.

3. **Sum of Squares of Digits**:
   - Implemented in the `getNext` function.
   - Extract each digit of the number `n`, square it, and add it to the sum.
   - Repeat until all digits have been processed.

4. **While Loop**:
   - The loop continues as long as `n` is not `1` (indicating happiness) and `n` is not in the set (indicating a cycle).
   - If `n == 1`, the function returns `true`.
   - If a cycle is detected, the function returns `false`.

5. **Example Walkthrough**:
   - Input: `n = 19`
     - Sequence: 19 → 82 → 68 → 100 → 1.
     - Since `n` reaches `1`, the function returns `true`.
   - Input: `n = 2`
     - Sequence: 2 → 4 → 16 → 37 → 58 → 89 → 145 → 42 → 20 → 4.
     - Since `n` enters a cycle, the function returns `false`.

6. **Key Insight**:
   - The sum of the squares of the digits of any number eventually falls below 243 (e.g., the maximum sum for 999 is \(9^2 + 9^2 + 9^2 = 243\)).
   - Thus, the sequence is guaranteed to either terminate at `1` or enter a cycle.

7. **Optimizations**:
   - Use the `HashSet` for efficient cycle detection (O(1) average-time complexity for membership checks and inserts).
   - This prevents infinite loops caused by repeated numbers.

Key Considerations:
- The algorithm works for any positive integer `n`.
- Ensures both correctness and efficiency by using cycle detection via a set.
*/


class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;
    }
    private int getNext(int n) {
        int sum = 0;
        while(n > 0) {
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
}