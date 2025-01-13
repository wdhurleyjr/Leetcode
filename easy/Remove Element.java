/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

This solution removes all occurrences of a specified value `val` from the array `nums` in-place
and returns the new length of the modified array. The algorithm ensures that the relative order
of the remaining elements is preserved.

Approach:
1. Use two pointers, `i` and `j`.
   - `i` represents the position in the array where the next valid (non-`val`) element should be placed.
   - `j` iterates through the array to check each element.
2. If `nums[j]` is not equal to `val`, copy `nums[j]` to `nums[i]` and increment `i`.
3. If `nums[j]` equals `val`, skip it by not modifying `nums[i]`.
4. At the end of the loop, `i` represents the new length of the array without the `val` elements.
*/


class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}