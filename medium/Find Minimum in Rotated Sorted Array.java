/*
Notes:

Time Complexity: O(log n)
Space Complexity: O(1)

This solution uses binary search to find the minimum element in a rotated sorted array.
The key insight is that the rotation creates a disruption in the sorted order, which can be leveraged
to efficiently locate the minimum element.

Approach:
1. Start with two pointers, `left` (beginning of the array) and `right` (end of the array).
2. Calculate the middle index, `mid`, and compare `nums[mid]` with `nums[right]`.
   - If `nums[mid] > nums[right]`, the minimum must be in the right half (excluding `mid`), so move `left = mid + 1`.
   - If `nums[mid] <= nums[right]`, the minimum is either at `mid` or in the left half, so move `right = mid`.
3. The loop continues until `left == right`, which will point to the minimum element.
4. Return `nums[right]` (or `nums[left]`, since they are the same when the loop exits).

Key Observations:
- Comparing `nums[mid]` with `nums[right]` is crucial because it allows us to identify whether the
  minimum is in the left or right half of the array.
- The condition `left < right` ensures that the search range narrows down to a single element.

Why `nums[right]`:
- The minimum element is guaranteed to be within the range [left, right].
- When the loop ends, both pointers converge on the minimum element.

Example:
Input: nums = [4, 5, 6, 1, 2, 3]
1. Initial: left = 0, right = 5
2. Iteration 1: mid = 2, nums[mid] = 6, nums[right] = 3 → left = mid + 1 = 3
3. Iteration 2: mid = 4, nums[mid] = 2, nums[right] = 3 → right = mid = 4
4. Iteration 3: mid = 3, nums[mid] = 1, nums[right] = 2 → right = mid = 3
5. Terminate: left = 3, right = 3 → return nums[right] = 1
*/


class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
}