/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

This solution calculates the number of ways to climb a staircase with `n` steps using a bottom-up approach with dynamic programming.

Algorithm:
1. Initialize two variables (`one` and `two`) to track the number of ways to reach the current and previous steps.
   - `one` tracks the ways to reach the step `i-1`, and `two` tracks the ways to reach the step `i-2`.
2. Start with both `one` and `two` set to 1, as there's only one way to reach the first and second steps.
3. Iterate from step 3 to step `n`:
   - Calculate the current number of ways to reach step `i` by summing the number of ways to reach the two previous steps (`one + two`).
   - Update `two` to the previous value of `one`, and update `one` to the current number of ways to reach step `i`.
4. Return the value of `one` after the loop, as it represents the number of ways to reach the `n`th step.

Key Insight:
This solution reduces space complexity to O(1) by storing only the last two computed values instead of using an array to store the number of ways for all steps. The time complexity is O(n) since we iterate once through all steps from 3 to `n`.

*/


class Solution {
    public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        for(int i = 0; i < n - 1; i++) {
            int temp = one;
            one = one + two;
            two = temp;
        }
        return one;
    }
}