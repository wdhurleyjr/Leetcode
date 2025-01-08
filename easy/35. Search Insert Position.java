/**
 * Notes:
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 *
 * This solution uses the Binary Search algorithm to efficiently locate the target value
 * or determine its insertion position in a sorted array. Binary Search repeatedly divides
 * the search range in half, making it logarithmic in time complexity.
 *
 * The solution involves the following steps:
 * 1. Initialize two pointers, `left` (start of the array) and `right` (end of the array).
 * 2. Calculate the middle index, `mid`, and compare `nums[mid]` with the target value.
 * 3. If `nums[mid]` matches the target, return `mid`.
 * 4. If `nums[mid]` is less than the target, adjust `left` to `mid + 1` to search the right half.
 * 5. If `nums[mid]` is greater than the target, adjust `right` to `mid - 1` to search the left half.
 * 6. When the loop ends, `left` will point to the correct insertion position for the target.
 *
 * The overall complexity is O(log n) because the array is repeatedly halved until the search range
 * is reduced to a single element.
 *
 * Lastly, the space complexity is O(1) because the algorithm operates in place without creating
 * additional data structures. All computations are performed using a fixed amount of memory,
 * ensuring constant space usage.
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
