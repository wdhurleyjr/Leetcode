/*
Notes:

Time Complexity: O(log n)
Space Complexity: O(1)

This solution uses the Binary Search algorithm to efficiently locate the target value
or determine its insertion position in a sorted array. Binary Search repeatedly divides
the search range in half, resulting in logarithmic time complexity.

Steps:
1. Initialize two pointers:
   - `left` points to the start of the array.
   - `right` points to the end of the array.
2. Calculate the middle index, `mid`, as `mid = left + (right - left) / 2`.
3. Compare `nums[mid]` with the target:
   - If `nums[mid]` matches the target, return `mid`.
   - If `nums[mid]` is less than the target, set `left = mid + 1` to search the right half.
   - If `nums[mid]` is greater than the target, set `right = mid - 1` to search the left half.
4. Repeat steps 2 and 3 until the search range is exhausted (i.e., `left > right`).
5. When the loop ends, `left` will point to the correct insertion position for the target.

Complexity:
- Time Complexity: O(log n) because the search range is halved with each iteration.
- Space Complexity: O(1) because the algorithm operates in place, using a constant amount of memory.

This approach is optimal for searching in sorted arrays due to its logarithmic efficiency and minimal space usage.
*/


class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
