/*
Notes:

Time Complexity: O(n)
Space Complexity: O(1)

Algorithm Explanation:
1. This solution uses the two-pointer technique to remove duplicates in-place from a sorted array.
2. The first pointer, `j`, keeps track of the position of the last unique element in the array.
3. The second pointer, `i`, iterates through the array starting from index 1 (the second element).
4. Whenever `nums[i]` is different from `nums[j]`, we increment `j` and update `nums[j]` with `nums[i]`.
5. At the end of the loop, all unique elements will be at the start of the array, and `j + 1` will
   represent the length of this unique portion.

Assumptions:
- The input array is sorted in non-decreasing order.
- The returned value is the length of the unique portion of the array, and the array itself is modified in place.
*/

class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[j]) {
                j++;
                nums[j] = nums[i];
            }
        }
        return j + 1;
    }
}


