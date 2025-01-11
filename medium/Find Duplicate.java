/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

This solution uses a clever approach to find the duplicate number in an array where:
1. The array contains n+1 integers.
2. Each integer is in the range [1, n].
3. Only one integer is duplicated, and it appears at least twice.

Algorithm Explanation:
1. Iterate through the array, treating the absolute value of each element as an index.
2. For each element `nums[i]`, calculate the corresponding index using `Math.abs(nums[i])`.
   - The absolute value ensures that negated values (due to marking) are handled properly.
3. Check the value at the calculated index:
   - If it is negative, the index has already been visited, meaning the current number is the duplicate.
   - Otherwise, negate the value at the calculated index to mark it as visited.
4. If no duplicate is found during the loop (which shouldn't happen with valid input), return -1.

Key Insights:
1. By negating the value at the index corresponding to a number, the algorithm tracks visited indices without requiring additional space.
2. The problem's guarantee ensures that values in the array always map to valid indices.

Example:
Input: nums = [3, 1, 3, 4, 2]
- First iteration (i=0): Mark nums[3] → nums = [3, 1, 3, -4, 2]
- Second iteration (i=1): Mark nums[1] → nums = [3, -1, 3, -4, 2]
- Third iteration (i=2): nums[3] is already negative → Duplicate is 3.

The algorithm modifies the array temporarily but works in-place, making it efficient in terms of both time and space.
*/


class Solution {
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[Math.abs(nums[i])] < 0) {
                return Math.abs(nums[i]);
            }
            nums[Math.abs(nums[i])] *= -1;
        }
        return -1;
    }
}