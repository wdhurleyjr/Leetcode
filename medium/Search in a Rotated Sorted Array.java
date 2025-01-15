/*
Notes:

Time Complexity: O(log n)
- The solution uses binary search, which divides the search range in half during each iteration.
  Thus, the time complexity is logarithmic relative to the size of the input array.

Space Complexity: O(1)
- The algorithm operates entirely in place, without requiring additional data structures.
  Memory usage is constant regardless of the input size.

Algorithm Explanation:
1. **Binary Search on Rotated Array**:
   - The array is rotated, so one side of the current segment (left to mid or mid to right) is guaranteed to be sorted.
   - By comparing `nums[left]` and `nums[mid]`, the algorithm identifies which side is sorted.

2. **Sorted Side Checks**:
   - If the left side is sorted (`nums[left] <= nums[mid]`):
     - Check if the `target` lies within the range `[nums[left], nums[mid])`. If so, narrow the search to the left by updating `right = mid - 1`.
     - Otherwise, narrow the search to the right by updating `left = mid + 1`.
   - If the right side is sorted:
     - Check if the `target` lies within the range `(nums[mid], nums[right]]`. If so, narrow the search to the right by updating `left = mid + 1`.
     - Otherwise, narrow the search to the left by updating `right = mid - 1`.

3. **Exit Condition**:
   - The loop continues until `left` exceeds `right`. If the `target` is not found, the function returns `-1`.

4. **Handling Edge Cases**:
   - Single-element arrays.
   - Arrays with minimal rotations.
   - Arrays where the `target` is at the boundaries or the pivot point.

Example:
For `nums = [4, 5, 6, 7, 0, 1, 2]` and `target = 0`:
- First, the algorithm identifies the sorted side at each step:
  - Initially, the left side is sorted (`[4, 5, 6, 7]`), but the `target` is in the right side, so it narrows the range.
  - Eventually, the `target` is located at index `4`.
*/


class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target) return mid;
            if(nums[left] <= nums[mid]) {
                if(nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(nums[right] >= target && nums[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
